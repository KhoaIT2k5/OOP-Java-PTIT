package MANG_DOI_TUONG.J05059_XAC_DINH_DANH_SACH_TRUNG_TUYEN;
import java.util.*;
class ThiSinh {
    private String ma, ten, trangThai;
    private double toan, ly, hoa;
    public ThiSinh(String ma, String ten, double toan, double ly, double hoa) {
        this.ma = ma;
        this.ten = ten;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public String getMa() {
        return ma;
    }
    public double getDiemUuTien() {
        if(this.ma.contains("KV2")) return 1.0;
        if(this.ma.contains("KV1")) return 0.5;
        return 2.5;
    }
    public double getTongDiem() {
        return  this.toan*2 + this.ly + this.hoa + getDiemUuTien();
    }
    private String formatDiem(double x) {
        if(x == (int) x) return Integer.toString((int)x);
        return String.format("%.1f", x);
    }
    @Override
    public String toString() {
        return this.ma + " "
                + this.ten + " "
                + formatDiem(this.getDiemUuTien()) + " "
                + formatDiem(this.getTongDiem()) + " " + this.trangThai ;
    }
}

public class J05059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        int chiTieu = sc.nextInt();
        Collections.sort(list, (x,y) -> {
            if(x.getTongDiem() != y.getTongDiem())
                return Double.compare(y.getTongDiem(),x.getTongDiem());
            else return x.getMa().compareTo(y.getMa());
        });
        ArrayList<ThiSinh> listTSTrongChiTieu = new ArrayList<>();
        for(int i=0 ; i<chiTieu ; i++) {
            list.get(i).setTrangThai("TRUNG TUYEN");
            listTSTrongChiTieu.add(list.get(i));
        }
        int idx = chiTieu - 1;
        for(int i=chiTieu ; i<n ; i++) {
            if(list.get(i).getTongDiem() == list.get(idx).getTongDiem()) {
                list.get(i).setTrangThai("TRUNG TUYEN");
                listTSTrongChiTieu.add(list.get(i));
            } else list.get(i).setTrangThai("TRUOT");
        }
        double diemChuan = listTSTrongChiTieu.get(listTSTrongChiTieu.size()-1).getTongDiem();
        System.out.printf("%.1f\n",diemChuan);
        for(ThiSinh x : list) System.out.println(x);
        sc.close();
    }
}
