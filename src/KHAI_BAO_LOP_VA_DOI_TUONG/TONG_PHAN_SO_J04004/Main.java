package KHAI_BAO_LOP_VA_DOI_TUONG.TONG_PHAN_SO_J04004;

import java.util.Scanner;
class PhanSo {
    private long tu, mau;

    public PhanSo() {
    }

    public PhanSo(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public long getTu() {
        return tu;
    }

    public void setTu(long tu) {
        this.tu = tu;
    }

    public long getMau() {
        return mau;
    }

    public void setMau(long mau) {
        this.mau = mau;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public void rutGon() {
        long ucln = gcd(getTu(), getMau());
        this.tu /= ucln;
        this.mau /= ucln;
    }
    public void add(PhanSo a) {
        long bcnn =  (a.mau / gcd(this.mau, a.mau)) * this.mau;
        this.tu = (bcnn/this.mau) * this.tu;
        a.tu = (bcnn/a.mau) * a.tu;
        this.mau = bcnn;
        this.tu = this.tu + a.tu;
        this.rutGon();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
            PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());
            a.rutGon(); b.rutGon();
            a.add(b);
            System.out.println(a.getTu() + "/" + a.getMau());
        sc.close();
    }
}
