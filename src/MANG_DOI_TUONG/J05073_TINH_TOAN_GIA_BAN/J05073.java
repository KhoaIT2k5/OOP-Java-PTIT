package MANG_DOI_TUONG.J05073_TINH_TOAN_GIA_BAN;
import java.util.*;
class DonHang{
    private String ma;
    private int donGia, soLuong;

    public DonHang(String ma, int donGia, int soLuong) {
        this.ma = ma;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    public double thue() {
        int tienHang = this.donGia * this.soLuong;
        if(this.ma.charAt(0) == 'T') return  (tienHang * 0.29);
        if(this.ma.charAt(0) == 'C') return  (tienHang * 0.1);
        if(this.ma.charAt(0) == 'D') return  (tienHang * 0.08);
        return (tienHang * 0.02);        
    }
    public double giamThue() {
        int n = this.ma.length();
        if(this.ma.charAt(n-1) == 'C') return  (thue() * 0.05);
        return 0;
    }
    public double ship() {
        int tienHang = this.donGia * this.soLuong;
        if(this.ma.charAt(0) == 'T') return  (tienHang * 0.04);
        if(this.ma.charAt(0) == 'C') return  (tienHang * 0.03);
        if(this.ma.charAt(0) == 'D') return  (tienHang * 0.025);
        return (tienHang * 0.005);        
    }
    public double tongTien() {
        return (this.donGia * this.soLuong + thue() + ship() - giamThue()) 
                + (this.donGia * this.soLuong + thue() + ship() - giamThue())*0.2;
    }
    public double giaBan() {
        return tongTien()/this.soLuong;
    }
    @Override
    public String toString() {
        return this.ma + " " + String.format("%.2f",giaBan());
    }
}
public class J05073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<DonHang> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) 
            list.add(new DonHang(sc.next(),sc.nextInt(),sc.nextInt()));
        for(DonHang x : list) {
            System.out.println(x);
        }
        sc.close();
    }
}
