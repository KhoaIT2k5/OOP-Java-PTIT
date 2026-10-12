package MANG_DOI_TUONG.J05049_LIET_KE_NHAP_XUAT_HANG_THEO_NHOM;
import java.util.*;
class MatHang {
    private String ma;
    private int soLuongNhap;

    public MatHang(String ma, int soLuongNhap) {
        this.ma = ma;
        this.soLuongNhap = soLuongNhap;
    }
    public String getMa() {
        return ma;
    }
    public int getSoLuongNhap() {
        return soLuongNhap;
    }
    public int soLuongXuat() {
        if(this.ma.startsWith("A")) return (int) Math.round(this.soLuongNhap * 0.6);
        return (int) Math.round(this.soLuongNhap * 0.7);
    }
    public int donGia() {
        if(this.ma.endsWith("Y")) return 110000;
        return 135000;
    }
    public int tien() { return donGia() * soLuongXuat();}
    public int thue() {
        if(this.ma.startsWith("A") && this.ma.endsWith("Y"))
            return (tien()/100) * 8;
        if(this.ma.startsWith("A") && this.ma.endsWith("N"))
            return (tien()/100) * 11;
        if(this.ma.startsWith("B") && this.ma.endsWith("Y"))
            return (tien()/100) * 17;
        return (tien()/100) * 22;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.soLuongNhap + " " +
                soLuongXuat() + " " + donGia() + " " + tien() + " " + thue();
    }
}
public class J05049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<MatHang> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            list.add(new MatHang(sc.next(),sc.nextInt()));
        }
        Collections.sort(list, new Comparator<MatHang>() {
           @Override 
           public int compare(MatHang x, MatHang y) {
                return y.thue() - x.thue();
           }
        });
        char[] nhom = sc.next().toCharArray();
        for(MatHang x : list) if(x.getMa().charAt(0) == nhom[0]) System.out.println(x);
        sc.close();
    }
}
