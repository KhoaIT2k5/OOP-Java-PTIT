
package MANG_DOI_TUONG.J05023_LIET_KE_SINH_VIEN_THEO_KHOA;

import java.util.*;

class SinhVien {
    private String ma, ten, lop, mail;
    public SinhVien(String ma, String ten, String lop, String mail) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.mail = mail;
    }
    public String getLop() {
        return lop;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.lop + " " + this.mail;
    }
}
public class J05023 {
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
            String yyyy = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN KHOA " + yyyy + ":");
            String tmp = yyyy.substring(2);
            for(SinhVien x : list) {
                String res = x.getLop().substring(1,3);
                if(res.equals(tmp)) System.out.println(x);
            } 
        }
        sc.close();
    }
}

//4
//B16DCCN011
//Nguyen Trong Duc Anh
//D16CNPM1
//sv1@stu.ptit.edu.vn
//B17DCCN215
//To Ngoc Hieu
//D15CNPM3
//sv2@stu.ptit.edu.vn
//B18DCKT150
//Nguyen Ngoc Son
//D15CQKT02-B
//sv3@stu.ptit.edu.vn
//B19DCKT199
//Nguyen Trong Tung
//D15CQKT02-B
//sv4@stu.ptit.edu.vn
//45
//2015