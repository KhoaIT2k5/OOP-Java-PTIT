package MANG_DOI_TUONG.J05020_SAP_XEP_SINH_VIEN_THEO_LOP;

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
public class J05020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            String ma = sc.nextLine(), ten = sc.nextLine(),
                    lop = sc.nextLine(), mail = sc.nextLine();
            list.add(new SinhVien(ma,ten,lop,mail));
        }
        Collections.sort(list, (x,y) -> {
            if(x.getLop().equals(y.getLop())) return x.getMa().compareTo(y.getMa());
            return x.getLop().compareTo(y.getLop());
        });
        for(SinhVien x : list) System.out.println(x);
        sc.close();
    }
}
