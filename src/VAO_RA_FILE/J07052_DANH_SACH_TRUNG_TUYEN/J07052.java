package VAO_RA_FILE.J07052_DANH_SACH_TRUNG_TUYEN;
import java.util.*;
import java.io.*;
class ThiSinh {
    private String ma,ten;
    private double toan,ly,hoa;
    private String trangThai;

    public ThiSinh(String ma, String ten, double toan, double ly, double hoa) {
        this.ma = ma;
        this.ten = chuanHoaTen(ten);
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }
    public String chuanHoaTen(String s) {
        String[] a = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<a.length ; i++) {
            sb.append(a[i].substring(0,1).toUpperCase())
                    .append(a[i].substring(1));
            if(i != a.length-1) sb.append(" ");
        }
        return sb.toString();
    }
    public double uuTien() {
        if(this.ma.contains("KV1")) return 0.5;
        if(this.ma.contains("KV2")) return 1;
        return 2.5;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public double diemXetTuyen() {
        return this.toan*2 + this.ly + this.hoa + uuTien();
    }
    private static String formatDiem(double x) {
        if(x == (int) x) return Integer.toString((int)x);
        return String.format("%.1f", x);
    }
    @Override
    public String toString() {
        return this.ma + " "
                + this.ten + " "
                + formatDiem(this.uuTien()) + " "
                + formatDiem(this.diemXetTuyen()) + " " + this.trangThai ;
    }
}
public class J07052 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        ArrayList<ThiSinh> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());    
        for(int i=0 ; i<n ; i++) {
            ThiSinh ts = new ThiSinh(
                sc.nextLine(), sc.nextLine(),
                sc.nextDouble(),sc.nextDouble(), sc.nextDouble()
            );
            sc.nextLine();
            list.add(ts);
        }
        Collections.sort(list, new Comparator<ThiSinh>() {
           @Override
           public int compare(ThiSinh x, ThiSinh y) {
               return Double.compare(y.diemXetTuyen(),x.diemXetTuyen());
           }
        });
        int chiTieu = sc.nextInt();
        ArrayList<ThiSinh> listTSTrongChiTieu = new ArrayList<>();
        for(int i=0 ; i<chiTieu ; i++) {
            list.get(i).setTrangThai("TRUNG TUYEN");
            listTSTrongChiTieu.add(list.get(i));
        } 
        int idx = chiTieu - 1;
        for(int i=chiTieu ; i<n ; i++) {
            if(list.get(i).diemXetTuyen() == list.get(idx).diemXetTuyen()) {
                list.get(i).setTrangThai("TRUNG TUYEN");
                listTSTrongChiTieu.add(list.get(i));
            } else list.get(i).setTrangThai("TRUOT");
        }
        double diemChuan = listTSTrongChiTieu.get(listTSTrongChiTieu.size()-1).diemXetTuyen();
        System.out.printf("%.1f\n",diemChuan);
        for(ThiSinh x : list) System.out.println(x);
        sc.close();
    }
}


//2
//KV2A002
//Hoang THAnh tuan
//5
//6
//5
//KV3B123
// LY Thi   THU ha
//8
//6.5
//7
//1