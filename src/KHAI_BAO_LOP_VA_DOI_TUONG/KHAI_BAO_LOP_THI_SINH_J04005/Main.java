package KHAI_BAO_LOP_VA_DOI_TUONG.KHAI_BAO_LOP_THI_SINH_J04005;
import java.util.*;
class ThiSinh {
    private String ten, ns;
    private double d1,d2,d3;

    public ThiSinh(double d3, double d2, double d1, String ns, String ten) {
        this.d3 = d3;
        this.d2 = d2;
        this.d1 = d1;
        this.ns = ns;
        this.ten = ten;
    }

    public ThiSinh() {}

    public String getTen() {
        return ten;
    }

    public double getD3() {
        return d3;
    }

    public double getD2() {
        return d2;
    }

    public double getD1() {
        return d1;
    }

    public String getNs() {
        return ns;
    }
    public double getTong() { return getD1() + getD2() + getD3(); }

    @Override
    public String toString() {
        return getTen() + " " + getNs() + " " + String.format(Locale.US, "%.1f", getTong());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ten = sc.nextLine(), ns = sc.next();
        double d1 = sc.nextDouble(), d2 = sc.nextDouble(), d3 = sc.nextDouble();
        ThiSinh ts = new ThiSinh(d3,d2,d1,ns,ten);
        System.out.println(ts);
        sc.close();
    }
}
