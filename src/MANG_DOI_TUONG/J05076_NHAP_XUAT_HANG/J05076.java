package MANG_DOI_TUONG.J05076_NHAP_XUAT_HANG;
import java.util.*;
class MatHang {
    private String ma,ten,loai;

    public MatHang(String ma, String ten, String loai) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
    }
    public double laiSuat() {
        if(this.loai.equals("A")) return 0.08;
        if(this.loai.equals("B")) return 0.05;
        return 0.02;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
    
    
}
class Data {
    private int soLuongNhap,soLuongXuat,donGiaNhap;
    private MatHang matHang;

    public Data(int soLuongNhap, int donGiaNhap,int soLuongXuat,  MatHang matHang) {
        this.soLuongNhap = soLuongNhap;
        this.soLuongXuat = soLuongXuat;
        this.donGiaNhap = donGiaNhap;
        this.matHang = matHang;
    }
    public int tongNhap() {
        return this.soLuongNhap * this.donGiaNhap;
    }
    public int tongXuat() {
        return (int) (this.donGiaNhap * this.soLuongXuat * (1 + this.matHang.laiSuat()));
    }
    @Override
    public String toString() {
        return this.matHang.getMa() + " " + this.matHang.getTen()
                + " " + tongNhap() + " " + tongXuat();
    }
}
public class J05076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        HashMap<String,MatHang> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            String ma = sc.nextLine(),ten = sc.nextLine(),loai = sc.nextLine();
            MatHang mh = new MatHang(ma,ten,loai);
            map.put(ma, mh);
        }
        int m = sc.nextInt();
        ArrayList<Data> list = new ArrayList<>();
        for(int i=0 ; i<m ; i++) {
            String  ma = sc.next();
            int soLuongNhap = sc.nextInt(),donGiaNhap = sc.nextInt()
                    ,soLuongXuat = sc.nextInt();
            list.add(new Data(soLuongNhap,donGiaNhap,soLuongXuat,map.get(ma)));
        }
        for(Data x : list) System.out.println(x);
        sc.close();
    }
}
