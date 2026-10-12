package VAO_RA_FILE.J07055_XEP_LOAI;
import java.io.*;
import java.util.*;

class SinhVien{
    private String ma,ten;
    private double d1,d2,d3;
    private static int stt = 1;
    public SinhVien(String ten, double d1, double d2, double d3) {
        this.ma = String.format("SV%02d",stt++);
        this.ten = chuanHoa(ten);
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }
    public String chuanHoa(String s) {
        String[] a = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<a.length ; i++) {
            sb.append(a[i].substring(0,1).toUpperCase())
                    .append(a[i].substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }
    public double diemTB() {
        return (this.d1*0.25 + this.d2*0.35 + this.d3*0.4);
    }

    public String getXepHang() {
        if(this.diemTB() >= 8) return "GIOI";
        if(this.diemTB() >= 6.5) return "KHA";
        if(this.diemTB() >= 5) return "TRUNG BINH";
        return "KEM";
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " 
                + String.format("%.2f",diemTB()) + " " + getXepHang();
    }
}
public class J07055 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<SinhVien> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            list.add(new SinhVien(sc.nextLine(),Double.parseDouble(sc.nextLine()),
            Double.parseDouble(sc.nextLine()),Double.parseDouble(sc.nextLine())));
        }
        Collections.sort(list, new Comparator<SinhVien>() {
           @Override
           public int compare(SinhVien x, SinhVien y) {
               return Double.compare(y.diemTB(),x.diemTB());
           }
        });
        for(SinhVien x : list) System.out.println(x);
        sc.close();
    }
}

