package MANG_DOI_TUONG.J05036_TINH_GIA_BAN_1;
import java.util.*;
class MatHang{
    private String ma,ten,donVi;
    private double donGiaNhap, soLuong;
    public static int stt = 1;
    public MatHang(String ten, String donVi, double donGiaNhap, double soLuong) {
        this.ma = String.format("MH%02d", stt++);
        this.ten = ten;
        this.donVi = donVi;
        this.donGiaNhap = donGiaNhap;
        this.soLuong = soLuong;
    }
    public long phiVanChuyen() {
        return Math.round(this.soLuong * this.donGiaNhap * 0.05);
    }
    public long thanhTien() {
        return Math.round(this.soLuong * this.donGiaNhap + phiVanChuyen());
    }
    public long giaBan() {
        return Math.round(thanhTien() + thanhTien()*0.02 );
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.donVi
                + " " + phiVanChuyen() + " " + thanhTien() + " " + giaBan();
    }
}
public class J05036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MatHang> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            String ten = sc.nextLine(), donVi = sc.nextLine();
            double donGiaNhap = Double.parseDouble(sc.nextLine()),
                    soLuong = Double.parseDouble(sc.nextLine());
            list.add(new MatHang(ten,donVi,donGiaNhap,soLuong));
        }
        for(MatHang x : list) {
            System.out.println(x);
        }
        sc.close();
    }
}
