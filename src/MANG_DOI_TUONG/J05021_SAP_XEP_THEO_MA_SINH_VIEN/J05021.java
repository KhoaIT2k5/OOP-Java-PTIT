package MANG_DOI_TUONG.J05021_SAP_XEP_THEO_MA_SINH_VIEN;

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
public class J05021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> list = new ArrayList<>();
        while(sc.hasNextLine()) {
            String ma = sc.nextLine(), ten = sc.nextLine(),
                    lop = sc.nextLine(), mail = sc.nextLine();
            list.add(new SinhVien(ma,ten,lop,mail));
        }
        Collections.sort(list, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien x, SinhVien y) {
                return x.getMa().compareTo(y.getMa());
            }
        });
        for(SinhVien x : list) System.out.println(x);
        sc.close();
    }
}
