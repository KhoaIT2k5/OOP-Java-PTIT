
package MANG_DOI_TUONG.J05045_SAP_XEP_NHAN_VIEN_THEO_THU_NHAP;
import java.util.*;
class NhanVien {
    private String ma, ten, chucVu;
    private long lcb, ngayCong;
    private static int stt = 1;
    public NhanVien(String ten, String chucVu, long lcb, long ngayCong) {
        this.ma = String.format("NV%02d",stt++ );
        this.ten = ten;
        this.chucVu = chucVu;
        this.lcb = lcb;
        this.ngayCong = ngayCong;
    }
    public String getMa() {
        return ma;
    }
    public long getLuongThang() { return this.lcb * this.ngayCong;}
    public long getPhuCap() {
        if(this.chucVu.equals("GD")) return 500;
        if(this.chucVu.equals("PGD")) return 400;
        if(this.chucVu.equals("TP")) return 300;
        if(this.chucVu.equals("KT")) return 250;
        return 100;
    }
    public long getTamUng() {
        long tamUng = (getPhuCap() + getLuongThang()) * 2/3;
        if(tamUng < 25000) 
            return Math.round(tamUng/1000.0) * 1000;
        return 25000;
    }    
    public long getConLai() {
        return getPhuCap() + getLuongThang() - getTamUng();
    }
    @Override
    public String toString() {
       return this.ma + " " + this.ten + " " + getPhuCap() + " " + getLuongThang() + " " + 
               getTamUng() + " " + getConLai();
    }
}
public class J05045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            sc.nextLine();
            list.add(new NhanVien(sc.nextLine(),sc.next(),sc.nextLong(),sc.nextLong()));
        }
        Collections.sort(list,(x,y) -> {
            if((x.getPhuCap() + x.getLuongThang()) == (y.getPhuCap() + y.getLuongThang()))
                return x.getMa().compareTo(y.getMa());
            return Long.compare((y.getPhuCap() + y.getLuongThang()),(x.getPhuCap() + x.getLuongThang()));
        });
        for(NhanVien x : list)  System.out.println(x);
        sc.close();
    }
}
