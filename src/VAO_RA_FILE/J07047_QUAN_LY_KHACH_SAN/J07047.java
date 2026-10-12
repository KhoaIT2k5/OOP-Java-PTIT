package VAO_RA_FILE.J07047_QUAN_LY_KHACH_SAN;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class KhachSan {
    private String loaiPhong, tenLoaiPhong;
    private int donGia;
    private double phucVu;

    public KhachSan(String loaiPhong, String tenLoaiPhong, int donGia, double phucVu) {
        this.loaiPhong = loaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.donGia = donGia;
        this.phucVu = phucVu;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public int getDonGia() {
        return donGia;
    }

    public double getPhucVu() {
        return phucVu;
    }
}

class KhachHang implements Comparable<KhachHang> {
    private String ma, ten;
    private String maPhong;
    private Date den, di;
    private KhachSan ks;
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
    private static int stt = 1;

    public KhachHang(String ten, String maPhong, String den, String di, KhachSan ks) throws ParseException {
        this.ma = String.format("KH%02d", stt++);
        this.ten = ten;
        this.maPhong = maPhong;
        this.den = sdf.parse(den);
        this.di = sdf.parse(di);
        this.ks = ks;
    }
    public long soNgay() {
        long timeMili = this.di.getTime() - this.den.getTime();
        long ngay = timeMili / 86400000;
        return ngay; 
    }
    public double tienTra() {
        if(soNgay() == 0) return this.ks.getDonGia() * (1 + this.ks.getPhucVu());
        return (soNgay() * this.ks.getDonGia() * (1 + this.ks.getPhucVu()));
    }
    public double giamGia() {
        if (soNgay() < 10) return 0;
        if (soNgay() < 20) return tienTra() * 0.02;
        if (soNgay() <= 30) return tienTra() * 0.04;
        return tienTra() * 0.06;   
    }

    public double tienTraThucTe() {
        return tienTra() - giamGia();
    }

    @Override
    public int compareTo(KhachHang other) {
        return Long.compare(other.soNgay(), this.soNgay());
    }

    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + 
               this.maPhong + " " + soNgay() + " " + String.format("%.2f", tienTraThucTe());
    }
}

public class J07047 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt();
        HashMap<String, KhachSan> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            KhachSan ks = new KhachSan(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
            map.put(ks.getLoaiPhong(), ks);
        }
        int m = sc.nextInt(); sc.nextLine();
        ArrayList<KhachHang> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String ten = sc.nextLine();
            String maPhong = sc.nextLine();
            String den = sc.nextLine();
            String di = sc.nextLine();
            KhachHang kh = new KhachHang(ten, maPhong, den, di, map.get(maPhong.substring(2, 3)));    
            list.add(kh);
        }
        Collections.sort(list);
        for (KhachHang x : list) System.out.println(x);
        sc.close();
    }
}
////2
////C THUONG 150 0.03
////B VIP 200 0.05
////2
////Nguyen Van Hoang
////55B1
////01/01/2021
////05/01/2021
////Nguyen Trung Dung
////04C6
////01/01/2021
////10/01/2021
//
