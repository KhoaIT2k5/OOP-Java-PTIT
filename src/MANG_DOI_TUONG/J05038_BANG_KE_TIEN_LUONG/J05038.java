package MANG_DOI_TUONG.J05038_BANG_KE_TIEN_LUONG;
import java.util.*;
class NhanVien {
    private String ten, chucVu, ma;
    private long luongNgay, soNgayCong;
    public static int stt = 1;
    public NhanVien(String ten, long luongNgay, long soNgayCong, String chucVu) {
        this.ma = String.format("NV%02d",stt++);
        this.ten = ten;
        this.chucVu = chucVu;
        this.luongNgay = luongNgay;
        this.soNgayCong = soNgayCong;
    }
    public long luongThang() { return this.luongNgay * this.soNgayCong; }
    public long phuCapChucVu() { 
        if(chucVu.equals("GD")) return 250000;
        if(chucVu.equals("PGD")) return 200000;
        if(chucVu.equals("TP")) return 180000;
        return 150000;
    }
    public long thuong() {
        if(this.soNgayCong >= 25) return (long) (luongThang() * 0.20);
        if(this.soNgayCong >= 22) return (long) (luongThang() * 0.1);
        return 0;
    }
    public long thucLinh() {
        return luongThang() + thuong() + phuCapChucVu();
    }
    @Override 
    public String toString() {
        return this.ma + " " + this.ten + " " + luongThang() + " "
                + thuong() + " " + phuCapChucVu() + " " + thucLinh();
    }
}
public class J05038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sum = 0;
        int  n = Integer.parseInt(sc.nextLine());
        ArrayList<NhanVien> list = new ArrayList<>();
        
        for(int i=1 ; i<=n ; i++) {
            NhanVien nv = new NhanVien(sc.nextLine(),Long.parseLong(sc.nextLine())
                    ,Long.parseLong(sc.nextLine()), sc.nextLine());
            sum += nv.thucLinh();
            list.add(nv);
        }
        for(NhanVien x : list) {
            System.out.println(x);
        }
        System.out.println("Tong chi phi tien luong: " + sum);
        sc.close();
    }
}
