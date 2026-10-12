package MANG_DOI_TUONG.J05051_SAP_XEP_BANG_TINH_TIEN_DIEN;
import java.util.*;
class TienDien {
    private String ma,loaiSD ;
    private long cu,moi;
    private static long stt = 1;
    public TienDien(String loaiSD, long cu, long moi) {
        this.ma = String.format("KH%02d",stt++);
        this.loaiSD = loaiSD;
        this.cu = cu;
        this.moi = moi;
    }
    public long heSo() {
        if(this.loaiSD.equals("KD")) return 3;
        if(this.loaiSD.equals("NN")) return 5;
        if(this.loaiSD.equals("TT")) return 4;
        return 2;
    }
    public long thanhTien() {
        return (this.moi - this.cu) * heSo() * 550;
    }
    public long phuTroi() {
        if(this.moi - this.cu < 50) return 0;
        if(this.moi - this.cu <= 100) return Math.round(thanhTien() * 0.35f);
        return thanhTien();
    }
    public long tongTien() {
        return thanhTien() + phuTroi();
    }
    @Override
    public String toString() {
       return this.ma + " " + heSo() + " " + thanhTien() + " " + phuTroi() + " " + tongTien();  
    }
}
public class J05051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        ArrayList<TienDien> list = new ArrayList<>();
        for(long i=1 ; i<=n ; i++) {
            list.add(new TienDien(sc.next(),sc.nextLong(),sc.nextLong()));
        }
        Collections.sort(list,new Comparator<TienDien>() {
            @Override
            public int compare(TienDien x, TienDien y) {
                return Long.compare(y.tongTien(),x.tongTien());
            }
        });
        for(TienDien x : list) System.out.println(x);
        sc.close();
    }
}
