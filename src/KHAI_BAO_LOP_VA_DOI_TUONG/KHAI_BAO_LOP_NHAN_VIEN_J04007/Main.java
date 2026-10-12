package KHAI_BAO_LOP_VA_DOI_TUONG.KHAI_BAO_LOP_NHAN_VIEN_J04007;

import java.util.Scanner;
class NhanVien {
    private String ten, gt, ns, dc, thue, hd;

    public NhanVien(String ten, String gt, String ns, String dc, String thue, String hd) {
        this.ten = ten;
        this.gt = gt;
        this.ns = ns;
        this.dc = dc;
        this.thue = thue;
        this.hd = hd;
    }

    public NhanVien() {
    }

    public String getTen() {
        return ten;
    }

    public String getGt() {
        return gt;
    }

    public String getNs() {
        return ns;
    }

    public String getDc() {
        return dc;
    }

    public String getThue() {
        return thue;
    }

    public String getHd() {
        return hd;
    }

    @Override
    public String toString() {
        return "00001 " + this.ten + " " + this.gt + " " + this.ns + " "
                + this.dc + " " + this.thue + " " + this.hd;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien nv = new NhanVien(sc.nextLine(),sc.nextLine(),sc.nextLine(),
                sc.nextLine(),sc.nextLine(),sc.nextLine());
        System.out.println(nv);
        sc.close();
    }
}
