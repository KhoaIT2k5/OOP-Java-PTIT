package MANG_DOI_TUONG.J05037_TINH_GIA_BAN2;


import java.util.*;
class MatHang{
    private String ma,ten,donVi;
    private long donGiaNhap, soLuong;
    public static int stt = 1;
    public MatHang(String ten, String donVi, long donGiaNhap, long soLuong) {
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
        return this.soLuong * this.donGiaNhap + phiVanChuyen();
    }
    public long giaBanLe() {
        return (long) Math.ceil(
                                (
                                    (thanhTien() + thanhTien()*0.02)/this.soLuong
                                )/100
                            ) * 100 ;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.donVi
                + " " + phiVanChuyen() + " " + thanhTien() + " " + giaBanLe();
    }
}
public class J05037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MatHang> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            String ten = sc.nextLine(), donVi = sc.nextLine();
            long donGiaNhap = Long.parseLong(sc.nextLine()),
                    soLuong = Long.parseLong(sc.nextLine());
            list.add(new MatHang(ten,donVi,donGiaNhap,soLuong));
        }
        Collections.sort(list,(x,y) -> {
            return Long.compare(y.giaBanLe(),x.giaBanLe());
        });
        for(MatHang x : list) {
            System.out.println(x);
        }
        sc.close();
    }
}
