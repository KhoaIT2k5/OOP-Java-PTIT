package MANG_DOI_TUONG.J05016_HOA_DON_KHACH_SAN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;  

class KhachHang {
    private String ten, soPhong, ma;
    private Date ngayNhan, ngayTra;
    private int dichVu;
    public static int stt = 1;
    public KhachHang(String ten, String soPhong, Date nhan, Date tra, int dichVu) {
        this.ma = String.format("KH%02d", stt++);
        this.ten = ten;
        this.soPhong = soPhong;
        this.ngayNhan = nhan;
        this.ngayTra = tra;
        this.dichVu = dichVu;
    }
    public long soNgayO() {
        long timeMili = Math.abs(this.ngayNhan.getTime() - this.ngayTra.getTime());
        return TimeUnit.DAYS.convert(timeMili,  TimeUnit.MILLISECONDS) + 1;
    }
    public long donGia() {
        if(this.soPhong.charAt(0) == '1') return 25;
        if(this.soPhong.charAt(0) == '2') return 34;
        if(this.soPhong.charAt(0) == '3') return 50;
        return 80;
    }
    public long thanhTien() {
        return donGia()*soNgayO() + (long)this.dichVu;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.soPhong + " " + soNgayO() + " " + thanhTien();
    }
}
public class J05016 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> list = new ArrayList<>();
        while(n-- > 0) {
            String ten = sc.nextLine();
            String soPhong = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String nhan = sc.nextLine(), tra = sc.nextLine();
            Date ngayNhan = sdf.parse(nhan); 
            Date ngayTra = sdf.parse(tra);
            int dichVu = Integer.parseInt(sc.nextLine());
            list.add(new KhachHang(ten,soPhong,ngayNhan,ngayTra,dichVu));
        }
        Collections.sort(list,(x,y) -> { 
            return Long.compare(y.thanhTien(), x.thanhTien());
        });
        for(KhachHang x : list) System.out.println(x);
        sc.close();
    }
}
