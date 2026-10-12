package QUAN_HE_GIUA_CAC_LOP.J06002_SAP_XEP_HOA_DON_BAN_QUAN_AO;
import java.util.*;
class SanPham {
    private String maLoai,ten;
    private int donGia1,donGia2;
    public SanPham(String maLoai, String ten, int donGia1, int donGia2) {
        this.maLoai = maLoai;
        this.ten = ten;
        this.donGia1 = donGia1;
        this.donGia2 = donGia2;
    }
    public String getMaLoai() {
        return maLoai;
    }
    public String getTen() {
        return ten;
    }
    public int getDonGia1() {
        return donGia1;
    }
    public int getDonGia2() {
        return donGia2;
    }
}
class HoaDon {
    private String maHoaDon;
    private int soLuongMua;
    private SanPham sanPham;
    private static int stt = 1;
    public HoaDon(String maHoaDon, int soLuongMua, SanPham sanPham) {
        this.maHoaDon = String.format("%s-%03d",maHoaDon,stt++);
        this.soLuongMua = soLuongMua;
        this.sanPham = sanPham;
    }
    public int thanhTien() {
        if(this.maHoaDon.charAt(2) == '1') 
            return this.sanPham.getDonGia1() * this.soLuongMua;
        return this.sanPham.getDonGia2() * this.soLuongMua;
    }
    public int giamGia() {
        if(this.soLuongMua >= 150) return (int) (thanhTien() * 0.5);
        if(this.soLuongMua >= 100) return (int) (thanhTien() * 0.3);
        if(this.soLuongMua >= 50) return (int) (thanhTien() * 0.15);
        return 0;
    }
    public int tienTra() {
        return thanhTien() - giamGia();
    }
    @Override
    public String toString() {
        return this.maHoaDon + " " + this.sanPham.getTen() + " " + giamGia() + " " + tienTra();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String,SanPham> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            SanPham sp = new SanPham(
                sc.nextLine(),sc.nextLine(),
                Integer.parseInt(sc.nextLine()),
                Integer.parseInt(sc.nextLine())
            );
            map.put(sp.getMaLoai(),sp);
        }
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<HoaDon> list = new ArrayList<>();
        for(int i=0 ; i<m ; i++) {
            String maHD = sc.next();
            int soLuongMua = sc.nextInt();
            HoaDon hd = new HoaDon(maHD,soLuongMua,map.get(maHD.substring(0,2)));
            list.add(hd);
        }
        Collections.sort(list, new Comparator<HoaDon>() {
           @Override
           public int compare(HoaDon x, HoaDon y) {
               return y.tienTra() - x.tienTra();
           }
        });
        for(HoaDon x : list) System.out.println(x);
        sc.close();
    }
}
