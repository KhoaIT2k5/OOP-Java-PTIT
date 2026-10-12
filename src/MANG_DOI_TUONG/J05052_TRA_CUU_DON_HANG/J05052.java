package MANG_DOI_TUONG.J05052_TRA_CUU_DON_HANG;
import java.util.*;
class DonHang {
    private String ma,tenHang ;
    private long donGia,soLuong;
    private static long stt = 1;
    public DonHang(String tenHang, String ma, long donGia, long soLuong) {
        this.ma = ma;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    public String sttDon() {
        return this.ma.substring(1,4);
    }
    public long giamGia() {
        int n = ma.length();
        long tmp = this.donGia * this.soLuong;
        if(this.ma.charAt(n-1) == '1') return (long) (tmp * 0.5f);
        return (long)(tmp * 0.3f); 
    }
    public long thanhTien() {
        return this.donGia * this.soLuong - giamGia();
    }
    @Override
    public String toString() {
       return this.tenHang + " " + this.ma + " " + sttDon() + " " + giamGia() + " " + thanhTien();  
    }
}
public class J05052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine());
        ArrayList<DonHang> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            list.add(new DonHang(sc.nextLine(),sc.next(), sc.nextLong(),sc.nextLong()));
            sc.nextLine();
        }
        for(int i=0 ; i<n ; i++) {
            System.out.println(list.get(i));
        }
        sc.close();
    }
}
