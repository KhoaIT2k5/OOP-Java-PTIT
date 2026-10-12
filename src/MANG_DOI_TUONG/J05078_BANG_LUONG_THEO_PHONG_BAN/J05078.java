package MANG_DOI_TUONG.J05078_BANG_LUONG_THEO_PHONG_BAN;
import java.util.*;
class PhongBan {
    private String ma,ten;

    public PhongBan(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }
}
class NhanVien {
    private String ma,ten;
    private int lcb,soNgayCong;
    private PhongBan pb;
    public NhanVien(String ma, String ten, int lcb, int soNgayCong, PhongBan pb) {
        this.ma = ma;
        this.ten = ten;
        this.lcb = lcb*1000;
        this.soNgayCong = soNgayCong;
        this.pb = pb;
    }

    public String getMa() {
        return ma;
    }
    
    public int heSo() {
        int namCT =  Integer.parseInt(this.ma.substring(1,3));
        if(this.ma.charAt(0) == 'A') {
            if(namCT <= 3 && namCT >= 1) return 10;
            if(namCT <= 8 && namCT >= 4) return 12;
            if(namCT <= 15 && namCT >= 9) return 14;
            if(namCT >= 16) return 20;
        } else if(this.ma.charAt(0) == 'B') {
            if(namCT <= 3 && namCT >= 1) return 10;
            if(namCT <= 8 && namCT >= 4) return 11;
            if(namCT <= 15 && namCT >= 9) return 13;
            if(namCT >= 16) return 16;
        } else if(this.ma.charAt(0) == 'C') {
            if(namCT <= 3 && namCT >= 1) return 9;
            if(namCT <= 8 && namCT >= 4) return 10;
            if(namCT <= 15 && namCT >= 9) return 12;
            if(namCT >= 16) return 14;
        } else if(this.ma.charAt(0) == 'D'){
            if(namCT <= 3 && namCT >= 1) return 8;
            if(namCT <= 8 && namCT >= 4) return 9;
            if(namCT <= 15 && namCT >= 9) return 11;
        }
        return 13;
    }
    public int luongThang() {
        return this.lcb * this.soNgayCong * heSo();
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + luongThang();
    }
}
public class J05078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String,PhongBan> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            String ma = sc.next(),ten = sc.nextLine().trim();
            PhongBan pb = new PhongBan(ma,ten);
            map.put(ma,pb);
        }
        int m = sc.nextInt();
        ArrayList<NhanVien> list = new ArrayList<>();
        for(int i=0 ; i<m ; i++) {
            sc.nextLine();
            String  ma = sc.nextLine(), ten = sc.nextLine();
            int lcb = sc.nextInt(),soNgayCong = sc.nextInt();
            list.add(new NhanVien(ma,ten,lcb,soNgayCong,map.get(ma.substring(3))));
        }
        String maPhongBan = sc.next();
        System.out.println("Bang luong phong " + map.get(maPhongBan).getTen() + ":");
        for(NhanVien x : list) {
            if(maPhongBan.equals(x.getMa().substring(3))) 
                System.out.println(x);
        }
        sc.close();
    }
}

