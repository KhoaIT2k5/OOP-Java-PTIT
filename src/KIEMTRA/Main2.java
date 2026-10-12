package KIEMTRA;
import java.util.*;
class NguoiCong {
    private String ma, hoVaTen;
    private int namSinh;
    private double hsl;
    private String dienThoai;
    private static int sma = 1;

    public NguoiCong() {
        this.ma = String.format("E%03d",sma++);
    }
    public void input(Scanner in) {
        this.hoVaTen = in.nextLine();
        this.namSinh = Integer.parseInt(in.nextLine());
        this.hsl = Double.parseDouble(in.nextLine());
        this.dienThoai= in.nextLine();
    }

    private String getMa() {
        return ma;
    }
    private int getTuoi() {
        return 2026 - this.namSinh;
    }
    @Override
    public String toString() {
        double luong = this.hsl * 10000;
        return this.ma + " " + this.hoVaTen + " " + this.getTuoi() + " " + this.dienThoai + " " + luong;
    }
}
class QLNC {
    private NguoiCong[] a;

    public QLNC(NguoiCong[] a) {
        this.a = a;
    }
    public void out() {
        for(NguoiCong nc : a) {
            System.out.println(nc.toString());
        }
    }
}
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        NguoiCong[] ds = new NguoiCong[n];
        for(int i=0 ; i<n ; i++) {
            ds[i] = new NguoiCong();
            ds[i].input(sc);
        }
        QLNC ql = new QLNC(ds);
        ql.out();
    }
}
