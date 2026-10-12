package VAO_RA_FILE.J07020_HOA_DON2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class KhachHang {
    private String ma,ten,gt,ns,dc;
    private static int stt = 1;
    public KhachHang(String ten, String gt, String ns, String dc) {
        this.ma = String.format("KH%03d",stt++);
        this.ten = ten;
        this.gt = gt;
        this.ns = ns;
        this.dc = dc;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getGt() {
        return gt;
    }

    public String getNs() {
        return ns;
    }

    public String getDc() {
        return dc;
    }

    public static int getStt() {
        return stt;
    }
}
class MatHang {
    private String ma,ten,donVi;
    private long mua,ban;
    private static int stt = 1;
    public MatHang(String ten, String donVi, long mua, long ban) {
        this.ma = String.format("MH%03d",stt++);
        this.ten = ten;
        this.donVi = donVi;
        this.mua = mua;
        this.ban = ban;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDonVi() {
        return donVi;
    }

    public long getMua() {
        return mua;
    }

    public long getBan() {
        return ban;
    }

    public static int getStt() {
        return stt;
    }
}
class HoaDon {
    private String ma;
    private KhachHang khachHang;
    private MatHang matHang;
    private int soLuong;
    private static int stt = 1;
    public HoaDon(KhachHang khachHang, MatHang matHang, int soLuong) {
        this.ma = String.format("HD%03d",stt++);
        this.khachHang = khachHang;
        this.matHang = matHang;
        this.soLuong = soLuong;
    }
    public long thanhTien() {
        return this.matHang.getBan() * this.soLuong;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.khachHang.getTen() + " " + this.khachHang.getDc()
                + " " + this.matHang.getTen() + " " + this.matHang.getDonVi()
                + " " + this.matHang.getMua() + " " + this.matHang.getBan()
                + " " + this.soLuong + " " + thanhTien();
    }
}
public class J07020 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("KH.in"));
        Scanner sc2 = new Scanner(new File("MH.in"));
        Scanner sc3 = new Scanner(new File("HD.in"));

        int n = Integer.parseInt(sc1.nextLine());
        HashMap<String,KhachHang> map1 = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String ten = sc1.nextLine();
            String gt = sc1.nextLine();
            String ns = sc1.nextLine();
            String dc = sc1.nextLine();
            KhachHang kh = new KhachHang(ten,gt,ns,dc);
            map1.put(kh.getMa(),kh);
        }
        
        int m = Integer.parseInt(sc2.nextLine());
        HashMap<String,MatHang> map2 = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            MatHang mh = new MatHang(sc2.nextLine(), sc2.nextLine(), 
                    Integer.parseInt(sc2.nextLine()),Integer.parseInt(sc2.nextLine())
            );
            map2.put(mh.getMa(), mh);
        }
        
        int k = sc3.nextInt();
        for (int i = 0; i < k; ++i) {
            String khachHangId = sc3.next();
            String matHangId = sc3.next();
            int soLuong = sc3.nextInt();
            HoaDon hd = new HoaDon(map1.get(khachHangId),map2.get(matHangId),soLuong);
            System.out.println(hd);
        }
        sc1.close();
        sc2.close();
        sc3.close();
    }
}

