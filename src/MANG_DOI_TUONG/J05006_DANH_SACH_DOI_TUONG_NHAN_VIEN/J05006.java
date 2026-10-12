package MANG_DOI_TUONG.J05006_DANH_SACH_DOI_TUONG_NHAN_VIEN;

import java.util.*;

public class J05006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> nv = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=1 ; i<=n ; i++) {
            String ma = String.format("%05d", i);
            String ten = sc.nextLine(), gt = sc.nextLine(), ns = sc.nextLine()
                    , dc = sc.nextLine(), mst = sc.nextLine(), hd = sc.nextLine();
            NhanVien s = new NhanVien(ma,ten,gt,ns,dc,mst,hd);
            nv.add(s);
           
        }
        for(NhanVien x : nv)  System.out.println(x);
        sc.close();
    }   
}
