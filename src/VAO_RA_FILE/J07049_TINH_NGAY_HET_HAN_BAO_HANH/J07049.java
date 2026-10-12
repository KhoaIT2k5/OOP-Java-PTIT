package VAO_RA_FILE.J07049_TINH_NGAY_HET_HAN_BAO_HANH;

import java.util.*;
import java.text.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class SanPham{
    private String ma,ten;
    private int gia,baoHanh;

    public SanPham(String ma, String ten, int gia, int baoHanh) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.baoHanh = baoHanh;
    }

    public String getMa() {
        return ma;
    }
    
    public String getTen() {
        return ten;
    }

    public int getGia() {
        return gia;
    }

    public int getBaoHanh() {
        return baoHanh;
    }
    
}
class KhachHang {
    private String ma,ten,dc;
    private SanPham sp;
    private int soLuong;
    private LocalDate ngayMua;
    private static int stt = 1;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public KhachHang(String ten, String dc, SanPham sp, int soLuong, String ngayMua) throws ParseException {
        this.ma = String.format("KH%02d",stt++);
        this.ten = ten;
        this.dc = dc;
        this.sp = sp;
        this.soLuong = soLuong;
        this.ngayMua = LocalDate.parse(ngayMua,dtf);
    }

    public String getMa() {
        return ma;
    }
    
    public LocalDate hetHan() {
        return this.ngayMua.plusMonths(this.sp.getBaoHanh());
    }
    public int thanhToan() {
        return this.sp.getGia() * this.soLuong;
    }
    @Override 
    public String toString() {
        return this.ma + " " + this.ten + " " + this.dc + " "
                + this.sp.getMa() + " " + thanhToan() + " " + hetHan().format(dtf);
    }
}
public class J07049 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = sc.nextInt(); sc.nextLine();
        HashMap<String,SanPham> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            SanPham sp = new SanPham(sc.nextLine(),sc.nextLine(),
                Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine()));
            map.put(sp.getMa(),sp);
        }
        
        ArrayList<KhachHang> list = new ArrayList<>();
        int m = sc.nextInt(); sc.nextLine();
        for(int i=0 ; i<m ; i++) {
            String ten = sc.nextLine(),dc = sc.nextLine(),
                    maSP = sc.nextLine();
            int soLuong = Integer.parseInt(sc.nextLine());
            String date = sc.nextLine();
            KhachHang kh = new KhachHang(ten,dc,map.get(maSP),soLuong,date);
            list.add(kh);
        }
        
        Collections.sort(list,(x,y) -> {
            if(x.hetHan().compareTo(y.hetHan()) == 0) return x.getMa().compareTo(y.getMa());
            return x.hetHan().compareTo(y.hetHan());
        });
        for(KhachHang x : list) { System.out.println(x);}
    }
}

//2
//KC740
//May khoan KC1
//39
//18
//KC742
//May cat KC2
//46
//12
//2
//Le Ngoc Long
//Hoang Mai
//KC740
//11
//21/05/2009
//Nguyen Sao Mai
//Hoan Kiem
//KC742
//17
//06/02/2009