package MANG_DOI_TUONG.J05003_DANH_SACH_DOI_TUONG_SINH_VIEN1;
import java.util.*;

class SinhVien {
    private String ten, lop, ns, ma;
    private double gpa;
    public static int stt = 1;
    public SinhVien(String ten, String lop, String ns, double gpa) {
        this.ma = "B20DCCN" + String.format("%03d", stt++);
        this.ten = ten;
        this.lop = lop;
        this.ns = chuanHoaNS(ns);
        this.gpa = gpa;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String chuanHoaNS(String ns) {
        String[] arr = ns.trim().split("/");
        return String.format("%02d/%02d/%04d", Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]) );
    }
    @Override
    public String toString() {
        return this.ma + " " +
               this.ten + " " +
               this.lop + " " +
               this.ns + " " +
               String.format("%.2f", this.gpa);
    }
}
public class J05003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String ns = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            SinhVien sv = new SinhVien(ten, lop, ns, gpa);
            System.out.println(sv);
        }
        sc.close();
    }
}

