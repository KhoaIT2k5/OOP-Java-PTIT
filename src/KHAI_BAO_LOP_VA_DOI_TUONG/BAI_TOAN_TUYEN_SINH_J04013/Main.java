package KHAI_BAO_LOP_VA_DOI_TUONG.BAI_TOAN_TUYEN_SINH_J04013;

import java.util.ArrayList;
import java.util.Scanner;

class ThiSinh {
    private String ma, ten;
    private double toan, ly, hoa;
    public ThiSinh(String ma, String ten, double toan, double ly, double hoa) {
        this.ma = ma;
        this.ten = ten;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }
    public double getDiemUuTien() {
        if(this.ma.contains("KV2")) return 1.0;
        if(this.ma.contains("KV1")) return 0.5;
        return 2.5;
    }
    public double getTongDiem() {
        return  this.toan*2 + this.ly + this.hoa;
    }
    public String getTrangThai() {
        double tong = getTongDiem()  + getDiemUuTien();
        return tong >= 24.0 ? "TRUNG TUYEN" : "TRUOT";
    }
    private String formatDiem(double x) {
        if(x == (int) x) return Integer.toString((int)x);
        return String.format("%.1f", x);
    }
    @Override
    public String toString() {
        return this.ma + " "
                + this.ten + " "
                + formatDiem(this.getDiemUuTien()) + " "
                + formatDiem(this.getTongDiem()) + " "
                + this.getTrangThai();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            ThiSinh ts = new ThiSinh(
                    sc.nextLine(), sc.nextLine(),
                    sc.nextDouble(),sc.nextDouble(), sc.nextDouble()
            );
            System.out.println(ts);
        sc.close();
    }
}
