package MANG_DOI_TUONG.J05024_LIET_KE_SINH_VIEN_THEO_NGANH;

import java.util.*;

class SinhVien {
    private String ma, ten, lop, mail;
    public SinhVien(String ma, String ten, String lop, String mail) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.mail = mail;
    }

    public String getMa() {
        return ma;
    }

    public String getLop() {
        return lop;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.lop + " " + this.mail;
    }
}
public class J05024 {
    public static String maNganh(String s) {
        if (s.equals("KE TOAN")) return "DCKT";
        if (s.equals("CONG NGHE THONG TIN")) return "DCCN";
        if (s.equals("AN TOAN THONG TIN")) return "DCAT";
        if (s.equals("VIEN THONG")) return "DCVT";
        return "DCDT";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            String ma = sc.nextLine(), ten = sc.nextLine(),
                    lop = sc.nextLine(), mail = sc.nextLine();
            list.add(new SinhVien(ma,ten,lop,mail));
        }
        int q = Integer.parseInt(sc.nextLine());
        for(int i=1 ; i<=q ; i++) {
            String nganh = sc.nextLine().toUpperCase();
            System.out.println("DANH SACH SINH VIEN NGANH " + nganh + ":");
            nganh = maNganh(nganh);
            for(SinhVien x : list) {
                if(x.getMa().substring(3,7).equals(nganh)) {
                    if(nganh.equals("DCAT") || nganh.equals("DCCN"))
                    {if(x.getLop().charAt(0) != 'E') System.out.println(x); }
                    else System.out.println(x);
                }
            } 
        }
        sc.close();
    }
}