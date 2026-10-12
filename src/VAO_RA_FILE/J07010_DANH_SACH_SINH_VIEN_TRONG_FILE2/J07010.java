package VAO_RA_FILE.J07010_DANH_SACH_SINH_VIEN_TRONG_FILE2;
import java.io.File;
import java.io.FileNotFoundException;
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
public class J07010 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SV.in"));
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

