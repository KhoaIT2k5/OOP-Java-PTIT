
package KHAI_BAO_LOP_VA_DOI_TUONG.BAI_TOAN_TINH_CONG_J04012;

import java.util.Scanner;
class NhanVien {
    private String ma, ten, chucVu;
    private double lcb, ngayCong;
    public NhanVien(String ma, String ten, double lcb, double ngayCong, String chucVu) {
        this.ma = ma;
        this.ten = ten;
        this.chucVu = chucVu;
        this.lcb = lcb;
        this.ngayCong = ngayCong;
    }
    public double getLuongThang() { return this.lcb * this.ngayCong;}
    public double getThuong() {
        double luongChinh = getLuongThang();
        if(this.ngayCong >= 25) return luongChinh * 0.2;
        if(this.ngayCong >= 22 && this.ngayCong < 25) return luongChinh * 0.1;
        return 0;
    }    
    public double getPhuCap() {
        if(this.chucVu.equals("GD")) return 250000;
        if(this.chucVu.equals("PGD")) return 200000;
        if(this.chucVu.equals("TP")) return 180000;
        return 150000;
    }
    public double getThuNhap() {
        return getLuongThang() + getThuong() + getPhuCap();
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " 
                + String.format("%.0f",this.getLuongThang()) + " " 
                +  String.format("%.0f",this.getThuong()) + " " 
                +  String.format("%.0f",this.getPhuCap()) + " " 
                +  String.format("%.0f",this.getThuNhap());
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien nv = new NhanVien(
                "NV01", 
                sc.nextLine(), 
                sc.nextDouble(), 
                sc.nextDouble(), 
                sc.next()
        );
        System.out.println(nv);
        sc.close();
    }
}
