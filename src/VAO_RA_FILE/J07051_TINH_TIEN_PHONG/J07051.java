package VAO_RA_FILE.J07051_TINH_TIEN_PHONG;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class KhachHang{
    private String ma,ten,soPhong;
    private LocalDate nhan,tra;
    private int dichVu;
    private static int stt = 1;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public KhachHang(String ten, String soPhong, String nhan, String tra, int dichVu) {
        this.ma = String.format("KH%02d",stt++);
        this.ten = chuanHoaTen(ten);
        this.soPhong = soPhong;
        this.nhan = LocalDate.parse(chuanHoaDate(nhan),dtf);
        this.tra = LocalDate.parse(chuanHoaDate(tra),dtf);
        this.dichVu = dichVu;
    }
    private static final String chuanHoaDate(String s) {
        String[] p = s.trim().split("/");
        return String.format("%02d/%02d/%04d", 
                Integer.parseInt(p[0]), 
                Integer.parseInt(p[1]), 
                Integer.parseInt(p[2]));
    }
    private static final String chuanHoaTen(String s) {
        String[] arr = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<arr.length ; i++) {
            sb.append(arr[i].substring(0,1).toUpperCase())
                    .append(arr[i].substring(1));
            if(i != arr.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
    public long soNgay() {
        long ngay = ChronoUnit.DAYS.between(this.nhan,this.tra) + 1;
        return ngay == 0 ? 1 : ngay;
    }
    public long donGia() {
        if(this.soPhong.charAt(0) == '1') return 25;
        if(this.soPhong.charAt(0) == '2') return 34;
        if(this.soPhong.charAt(0) == '3') return 50;
        return 80;
    }
    public long thanhTien() {
        return soNgay() * donGia() + this.dichVu;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.soPhong
                + " " + soNgay() + " " + thanhTien();
    }
}
public class J07051 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<KhachHang> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            list.add( new KhachHang(sc.nextLine(),sc.nextLine(),
            sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine())) );
        }
        Collections.sort(list,new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang x, KhachHang y) {
                return Long.compare(y.thanhTien(),x.thanhTien());
            }
        });
        for(KhachHang x : list) { System.out.println(x);}
    }
}


//3
//Huynh VAN Thanh   
//103 
//5/6/2010   
//5/6/2010   
//15
//le   DUC cong  
//106 
//08/3/2010   
//1/5/2010   
//220
//Tran Thi Bich Tuyen   
//207 
//10/4/2010   
//21/4/2010   
//96