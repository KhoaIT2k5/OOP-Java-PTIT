
package MANG_DOI_TUONG.J05067_QUAN_LY_KHO_XANG_DAU;
import java.util.*;
class XangDau {
    private String maDonHang;
    private long soLuong;

    public XangDau(String maDonHang,long soLuong) {
        this.maDonHang = maDonHang;
        this.soLuong = soLuong;
    }
    public String hangSanXuat() {
        String hang = this.maDonHang.substring(this.maDonHang.length()-2);
        if(hang.equals("BP")) return "British Petro";
        if(hang.equals("ES")) return "Esso";
        if(hang.equals("SH")) return "Shell";
        if(hang.equals("CA")) return "Castrol";
        if(hang.equals("MO")) return "Mobil";
        return "Trong Nuoc";
    }
    public long donGia() {
        if(this.maDonHang.charAt(0) == 'X') return 128000;
        if(this.maDonHang.charAt(0) == 'D') return 11200;
        return 9700;
    }
    public long thue() {
        if(hangSanXuat().equals("Trong Nuoc")) return 0;
        long tien = donGia() * this.soLuong;
        if(this.maDonHang.charAt(0) == 'X') return (long) tien*3/100;
        if(this.maDonHang.charAt(0) == 'D') return (long) tien*35/1000;
        return (long) tien*2/100;
    }
    public long thanhTien() {
        return donGia() * this.soLuong + thue();
    }
    @Override
    public String toString() {
        return this.maDonHang + " " + hangSanXuat() + 
                " " + donGia() + " " + thue() + " " + thanhTien();
    }
}
public class J05067 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<XangDau> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) 
            list.add(new XangDau(sc.next(), sc.nextLong()));
        for(XangDau x : list) System.out.println(x);
        sc.close();
    }
}
