package KHAI_BAO_LOP_VA_DOI_TUONG.PHAN_SO_J04003;
import java.util.*;
import java.math.*;

public class PhanSo {
    private long tu,mau;
    public PhanSo() {}
    public PhanSo(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }
    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public long getMau() {
        return mau;
    }
    public void setMau(long mau) {
        this.mau = mau;
    }
    public long getTu() {
        return tu;
    }
    public void setTu(long tu) {
        this.tu = tu;
    }
    public String rutGon() {
        long ucln = gcd(getTu(), getMau());
        return getTu()/ucln + "/" + getMau()/ucln;
    }
}
