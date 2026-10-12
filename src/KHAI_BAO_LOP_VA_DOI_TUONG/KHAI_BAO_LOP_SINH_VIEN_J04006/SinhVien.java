package KHAI_BAO_LOP_VA_DOI_TUONG.KHAI_BAO_LOP_SINH_VIEN_J04006;

import java.util.Scanner;

class sv {
    private String ten,lop,ns;
    private float gpa;

    public sv() {
    }

    public sv(String ten, float gpa, String ns, String lop) {
        this.ten = ten;
        this.gpa = gpa;
        String[] a = ns.split("/");
        ns = String.format("%02d/%02d/%04d", Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
        this.ns = ns;
        this.lop = lop;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public String getNs() {
        return ns;
    }

    public float getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "B20DCCN001 " + this.ten + " " + this.lop + " " + this.ns + " " + String.format("%.2f", this.gpa);
    }
}
public class SinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ten = sc.nextLine(), lop = sc.next(), ns = sc.next();
        float gpa = sc.nextFloat();
        sv res = new sv(ten,gpa,ns,lop);
        System.out.println(res);
        sc.close();
    }
}
