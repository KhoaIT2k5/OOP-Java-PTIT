package MANG_DOI_TUONG.J05058_SAP_XEP_KET_QUA_TUYEN_SINH;
import java.util.*;
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
    public String getMa() {
        return ma;
    }
    public double getDiemUuTien() {
        if(this.ma.contains("KV2")) return 1.0;
        if(this.ma.contains("KV1")) return 0.5;
        return 2.5;
    }
    public double getTongDiem() {
        return  this.toan*2 + this.ly + this.hoa + getDiemUuTien();
    }
    public String getTrangThai() {
        return getTongDiem() >= 24.0 ? "TRUNG TUYEN" : "TRUOT";
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

public class J05058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ThiSinh> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0 ; i<n ; i++) {
            ThiSinh ts = new ThiSinh(
                    sc.nextLine(), sc.nextLine(),
                    sc.nextDouble(),sc.nextDouble(), sc.nextDouble()
            );
            sc.nextLine();
            list.add(ts);
        }
        Collections.sort(list, (x,y) -> {
            if(x.getTongDiem() != y.getTongDiem())
                return Double.compare(y.getTongDiem(),x.getTongDiem());
            else return x.getMa().compareTo(y.getMa());
        });
        for(ThiSinh x : list) System.out.println(x);
        sc.close();
    }
}
