package MANG_DOI_TUONG.J05017_HOA_DON_TIEN_NUOC;

import java.util.*;

class KhachHang {
    private String tenKhachHang, ma;
    private long chiSoCu, chiSoMoi;
    public static int stt = 1;
    public KhachHang(String tenKhachHang, long chiSoCu, long chiSoMoi) {
        this.ma = "KH" + String.format("%02d",stt++);
        this.tenKhachHang = tenKhachHang;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
    }
    public double soNuoc() {
        return this.chiSoMoi - this.chiSoCu;
    }
    public double tongTien() {
        if(soNuoc() <= 50) return soNuoc() * 100 * 1.02;
        else if(soNuoc() <= 100) return (50 * 100 + (soNuoc()-50)*150) * 1.03;
        return  (50 * 100 + 50 * 150 + (soNuoc()-100) * 200) * 1.05;
    }
    
    @Override 
    public String toString() {
        return this.ma + " " + this.tenKhachHang + " " + String.format("%.0f",tongTien());
    }
}
public class J05017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> list = new ArrayList<>();
        while(n-- > 0) {
            String ten = sc.nextLine();
            long chiSoCu = Long.parseLong(sc.nextLine()),
                    chiSoMoi = Long.parseLong(sc.nextLine());
            list.add(new KhachHang(ten, chiSoCu, chiSoMoi));
        }
        Collections.sort(list,(x,y) -> {
           return Double.compare(y.tongTien(),x.tongTien());
        });
        for(KhachHang x : list) System.out.println(x);
        sc.close();
    }
}
