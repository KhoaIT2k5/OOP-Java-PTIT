package MANG_DOI_TUONG.J07038_DANH_SACH_THUC_TAP3;
import java.io.*;
import java.util.*;
class SinhVien {
    private String ma, ten, lop, mail;
    public SinhVien(String ma, String ten, String lop, String mail) {
        this.ma = ma;
        this.ten = chuanHoa(ten); 
        this.lop = lop;
        this.mail = mail;
    }
    private String chuanHoa(String s) {
        String[] words = s.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public String getMa() {
        return ma;
    }
    public String getTen() {
        return ten;
    }
    public String getLop() {
        return lop;
    }
    public String getMail() {
        return mail;
    }
}
class DoanhNghiep {
    private String ma, ten;
    private int soLuong;
    public DoanhNghiep(String ma, String ten, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public String getTen() {
        return ten;
    }
    public String getMa() {
        return ma;
    }
}
class ThucTap {
    private SinhVien sinhVien;
    private DoanhNghiep doanhNghiep;
    public ThucTap(SinhVien sinhVien, DoanhNghiep doanhNghiep) {
        this.sinhVien = sinhVien;
        this.doanhNghiep = doanhNghiep;
    }
    public String getTenDoanhNghiep() {
        return this.doanhNghiep.getTen();
    }
    public String getMaDN() {
        return doanhNghiep.getMa();
    }
    public String getMaSV() {
        return this.sinhVien.getMa();
    }
    @Override
    public String toString() {
        return getMaSV() + " " + this.sinhVien.getTen() + " " + this.sinhVien.getLop();
    }
}

public class J07038 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc1.nextLine());
        HashMap<String, SinhVien> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            SinhVien sv = new SinhVien(
                    sc1.nextLine(),
                    sc1.nextLine(),
                    sc1.nextLine(),
                    sc1.nextLine()
            );
            map1.put(sv.getMa(), sv);
        }
        Scanner sc2 = new Scanner(new File("DN.in"));
        int m = Integer.parseInt(sc2.nextLine());
        HashMap<String, DoanhNghiep> map2 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            DoanhNghiep dn = new DoanhNghiep(
                    sc2.nextLine(), sc2.nextLine(),
                    Integer.parseInt(sc2.nextLine())
            );
            map2.put(dn.getMa(), dn);
        }
        Scanner sc3 = new Scanner(new File("THUCTAP.in"));
        int k = Integer.parseInt(sc3.nextLine());
        ArrayList<ThucTap> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String maSV = sc3.next();
            String maDN = sc3.next();
            ThucTap tt = new ThucTap(map1.get(maSV), map2.get(maDN));
            list.add(tt);
        }
        Collections.sort(list, (x, y) -> x.getMaSV().compareTo(y.getMaSV()));
        sc3.nextLine(); 
        int l = Integer.parseInt(sc3.nextLine());
        while (l-- > 0) {
            String maDN = sc3.nextLine();
            DoanhNghiep dn = map2.get(maDN);
            
            System.out.println("DANH SACH THUC TAP TAI " + dn.getTen() + ":");
            
            int limit = dn.getSoLuong(); // Lấy chỉ tiêu của doanh nghiệp
            int count = 0; // Biến đếm số lượng sinh viên đã nhận
            
            for (ThucTap x : list) {
                if (x.getMaDN().equals(maDN)) {
                    System.out.println(x);
                    count++;
                    if (count == limit) break;  // Nếu đã nhận đủ chỉ tiêu thì dừng luôn, không in thêm nữa
                }
            }
        }
    }
}