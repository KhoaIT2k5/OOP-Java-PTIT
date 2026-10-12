package KHAI_BAO_LOP_VA_DOI_TUONG.TINH_THU_NHAP_CHO_GIAO_VIEN_J04015;


import java.util.*;

class GiaoVien {
    private String ma, ten, lcb;
    public GiaoVien(String ma, String ten, String lcb) {
        this.ma = ma;
        this.ten = ten;
        this.lcb = lcb;
    }
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getLcb() {
        return lcb;
    }

    public void setLcb(String lcb) {
        this.lcb = lcb;
    }
    public String getPhuCap() {
        if(this.ma.contains("HT")) return "2000000";
        else if(this.ma.contains("HP")) return "900000";
        else return "500000";
    }
    
    public long getHeSo() {
        return Long.parseLong(this.ma.substring(2));
    }
    
    public long getThuNhap() {
        return Long.parseLong(this.lcb) * getHeSo() + Long.parseLong(getPhuCap());
    }
    @Override
    public String toString() {
        return this.ma + " "
                + this.ten + " "
                + this.getHeSo() + " "
                + this.getPhuCap() + " "
                + this.getThuNhap();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GiaoVien gv = new GiaoVien(
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine()
        );
        System.out.println(gv);
        sc.close();
    }
}
