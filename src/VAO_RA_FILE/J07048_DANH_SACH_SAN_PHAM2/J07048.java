package VAO_RA_FILE.J07048_DANH_SACH_SAN_PHAM2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SanPham implements Comparable<SanPham>{
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

    public int getGia() {
        return gia;
    }
    
    @Override
    public int compareTo(SanPham o) {
        if(this.gia == o.getGia()) return this.ma.compareTo(o.getMa());
        return -(this.gia - o.getGia());
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.gia + " " + this.baoHanh;
    }
}
public class J07048 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        ArrayList<SanPham> list = new ArrayList<>();
        int n = sc.nextInt(); sc.nextLine();
        for(int i=0 ; i<n ; i++) {
            list.add(new SanPham(sc.nextLine(),sc.nextLine()
            ,Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine())
            ));
        }
        Collections.sort(list);
        for(SanPham x : list) { System.out.println(x);}
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