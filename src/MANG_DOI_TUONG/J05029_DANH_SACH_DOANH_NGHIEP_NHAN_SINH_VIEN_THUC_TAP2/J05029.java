package MANG_DOI_TUONG.J05029_DANH_SACH_DOANH_NGHIEP_NHAN_SINH_VIEN_THUC_TAP2;

import java.util.*;

class doanhNghiep {
    private String ma, ten;
    private int soLuong;

    public doanhNghiep(String ma, String ten, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
    }
    public int getSoLuong() {
        return soLuong;
    }

    public String getMa() {
        return ma;
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.soLuong;
    }
}
public class J05029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<doanhNghiep> list = new ArrayList<>();
        for(int i =1 ; i<=n ; i++) 
            list.add(new doanhNghiep(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        Collections.sort(list,(doanhNghiep x,doanhNghiep y) -> {
           if(x.getSoLuong() != y.getSoLuong()) return y.getSoLuong() - x.getSoLuong();
           return x.getMa().compareTo(y.getMa());
        });
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU " + a + " DEN " + b + " SINH VIEN:");
            for(doanhNghiep x : list) 
                if(x.getSoLuong() >= a && x.getSoLuong() <= b)System.out.println(x);
        }
        sc.close();
    }
}
