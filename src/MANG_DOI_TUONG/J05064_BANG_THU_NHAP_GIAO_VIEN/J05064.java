package MANG_DOI_TUONG.J05064_BANG_THU_NHAP_GIAO_VIEN;
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
public class J05064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GiaoVien> list = new ArrayList<>();
        int cntHT = 0, cntHP = 0;
        for(int i=0 ; i<n ; i++) {
            GiaoVien gv = new GiaoVien(
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine()
            );
            if(gv.getMa().contains("HT")) cntHT++; else if(gv.getMa().contains("HP")) cntHP++; 
            if((cntHT <=1 && gv.getMa().contains("HT"))
                || (cntHP <=2 && gv.getMa().contains("HP"))
                || (!gv.getMa().contains("HT") && !gv.getMa().contains("HP"))
            ) list.add(gv);   
        }
        for(GiaoVien x : list) { System.out.println(x);}
        sc.close();
    }
}
