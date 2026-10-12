/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MANG_DOI_TUONG.J05041_SAP_XEP_BANG_TINH_CONG;
import java.util.*;
class NhanVien {
    private String ten, chucVu, ma;
    private long luongNgay, soNgayCong;
    public static int stt = 1;
    public NhanVien(String ten, long luongNgay, long soNgayCong, String chucVu) {
        this.ma = String.format("NV%02d",stt++);
        this.ten = ten;
        this.chucVu = chucVu;
        this.luongNgay = luongNgay;
        this.soNgayCong = soNgayCong;
    }
    public long luongThang() { return this.luongNgay * this.soNgayCong; }
    public long phuCapChucVu() { 
        if(chucVu.equals("GD")) return 250000;
        if(chucVu.equals("PGD")) return 200000;
        if(chucVu.equals("TP")) return 180000;
        return 150000;
    }
    public long thuong() {
        if(this.soNgayCong >= 25) return (long) (luongThang() * 0.20);
        if(this.soNgayCong >= 22) return (long) (luongThang() * 0.1);
        return 0;
    }
    public long thucLinh() {
        return luongThang() + thuong() + phuCapChucVu();
    }
    @Override 
    public String toString() {
        return this.ma + " " + this.ten + " " + luongThang() + " "
                + thuong() + " " + phuCapChucVu() + " " + thucLinh();
    }
}
public class J05041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = Integer.parseInt(sc.nextLine());
        ArrayList<NhanVien> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            NhanVien nv = new NhanVien(sc.nextLine(),Long.parseLong(sc.nextLine())
                    ,Long.parseLong(sc.nextLine()), sc.nextLine());
            list.add(nv);
        }
        Collections.sort(list,(x,y) -> {
            return Long.compare(y.thucLinh(), x.thucLinh());
        });
        for(NhanVien x : list) System.out.println(x);
        sc.close();
    }
}