package KHAI_BAO_LOP_VA_DOI_TUONG.TINH_TOAN_PHAN_SO_J04014;

import java.util.*;

class ps {
    private long tu, mau;
    public ps(){}
    public ps(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }
    public void setTu(long tu) { this.tu = tu; }
    public long getTu() { return tu;}
    public void setMau(long mau) { this.mau = mau; }
    public long getMau() { return mau;}

    @Override
    public String toString() { return tu + "/" + mau; }
}

public class tinhtoanphanso {
     public static long ucln(long a, long b) {
        if(b == 0) return a;
        return ucln(b,a%b);
    }
    public static long bcnn(long a, long b) { return a*b/ucln(a,b); }
    
    public static void rutgon(ps a) {
        long tu = a.getTu(), mau = a.getMau();
        long tmp = ucln(tu, mau);
        a.setTu(a.getTu()/tmp); 
        a.setMau(a.getMau()/tmp);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        while(t-- > 0) {
            long x = sc.nextLong(), y = sc.nextLong();
            ps p1 = new ps(x,y);

            x = sc.nextLong(); y = sc.nextLong();
            ps p2 = new ps(x,y);

            ps tong = new ps();
            tong.setTu((p1.getTu()*p2.getMau() + p2.getTu()*p1.getMau()) * (p1.getTu()*p2.getMau() + p2.getTu()*p1.getMau()));
            tong.setMau((p1.getMau()*p2.getMau()) * (p1.getMau()*p2.getMau()));
            rutgon(tong);
            System.out.print(tong + " ");

            ps tich = new ps();
            tich.setTu(p1.getTu()*p2.getTu()*tong.getTu());
            tich.setMau(p1.getMau()*p2.getMau()*tong.getMau());
            rutgon(tich);
            System.out.println(tich);
        }
        sc.close();
    }
}