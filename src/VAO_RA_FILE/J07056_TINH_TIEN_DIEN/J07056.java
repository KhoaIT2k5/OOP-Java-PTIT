package VAO_RA_FILE.J07056_TINH_TIEN_DIEN;
import java.util.*;
import java.io.*;
class KhachHang {
    private String ten,loai,ma;
    private int csDau, csCuoi;
    private static int stt = 1;
    public KhachHang(String ten, String loai, int csDau, int csCuoi) {
        this.ma = String.format("KH%02d",stt++);
        this.ten = chuanHoa(ten);
        this.loai = loai;
        this.csDau = csDau;
        this.csCuoi = csCuoi;
    }
    public static String chuanHoa(String s) {
        String[] a = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<a.length ; i++) {
            sb.append(a[i].substring(0,1).toUpperCase())
                    .append(a[i].substring(1).toLowerCase())
                    .append(" ");
        }
        return sb.toString().trim();
    }
    public int dinhMuc() {
        if("A".equals(this.loai)) return 100;
        if("B".equals(this.loai)) return 500;
        return 200;
    }
    public int soDien() {
       return this.csCuoi - this.csDau;
    }
    public int tienTrongDinhMuc() {
        return Math.min(soDien(),dinhMuc()) * 450;
    }
    public int tienVuotDinhMuc() {
        if(soDien() > dinhMuc()) return (soDien() - dinhMuc()) * 1000;
        return 0;
    }
    public int VAT() {
        return (int)(tienVuotDinhMuc() * 0.05);
    }
    public int tienTra() {
        return (tienTrongDinhMuc() + tienVuotDinhMuc() + VAT());
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + tienTrongDinhMuc()
                + " " + tienVuotDinhMuc() + " " + VAT() + " " + tienTra() ;
    }
}
public class J07056 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = sc.nextInt(); sc.nextLine();
        KhachHang[] a = new KhachHang[n];
        for(int i=0 ; i<n ; i++) {
            String ten = sc.nextLine();
            String loai = sc.next();
            int csDau = sc.nextInt(), csCuoi = sc.nextInt();
            a[i] = new KhachHang(ten,loai,csDau,csCuoi);
            sc.nextLine();
        }
        Arrays.sort(a,(x,y) -> {
            return y.tienTra() - x.tienTra();
        });
        for(KhachHang x : a)  System.out.println(x);
        sc.close();
    }
}

//2
// nGuyEn Hong Ngat
//C 200 278
// Chu thi    minh
//A 120 160