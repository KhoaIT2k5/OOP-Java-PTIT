/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MANG_DOI_TUONG.J05074_DIEM_DANH1;
import java.util.*;
class SinhVien {
    private String ma, ten, lop;

    public SinhVien(String ma, String ten, String lop) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
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
    
}
class DiemDanh {
    private String data;
    private SinhVien sv;

    public DiemDanh(String data, SinhVien sv) {
        this.data = data;
        this.sv = sv;
    }
    public int vang() {
        int cnt = 0;
        for(Character x : this.data.toCharArray()) 
            if(x == 'v') cnt++;
        return cnt;
    }
    public int muon() {
        int cnt = 0;
        for(Character x : this.data.toCharArray()) 
            if(x == 'm') cnt++;
        return cnt;
    }
    public int coMat() {
        int cnt = 0;
        for(Character x : this.data.toCharArray()) 
            if(x == 'x') cnt++;
        return cnt;
    }
    public int chuyenCan() {
        int diem = (10 - 2*vang() - muon());
        return  diem < 0 ? 0 : diem;
    }
    public String ghiChu() {
        if(chuyenCan() == 0) return "KDDK";
        return "";
    }
    @Override
    public String toString() {
        return this.sv.getMa() + " " + this.sv.getTen() + " " 
                + this.sv.getLop() + " " + chuyenCan() + " " + ghiChu();
    }
}
public class J05074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String,SinhVien> map = new HashMap<>();
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            String ma = sc.nextLine(), ten = sc.nextLine(), lop = sc.nextLine();
            SinhVien tmp = new SinhVien(ma,ten,lop);
            map.put(ma,tmp);
            dsSV.add(tmp);
        }
        HashMap<String, DiemDanh> dd = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            String ma = sc.next(), data = sc.next();
            DiemDanh tmp = new DiemDanh(data,map.get(ma));
            dd.put(ma,tmp);
        }
        String lop = sc.next();
        for(SinhVien sv : dsSV)  System.out.println(dd.get(sv.getMa()));
        sc.close();
    }
}
