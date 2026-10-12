/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MANG_DOI_TUONG.J05030_BANG_DIEM_THANH_PHAN1;

import java.util.*;
class SinhVien {
    private String ma,ten,lop;
    private double d1,d2,d3;

    public SinhVien(String ma, String ten, String lop, double d1, double d2, double d3) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public String getMa() {
        return ma;
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.lop + String.format(" %.1f %.1f %.1f", d1,d2,d3);
    }
    
}
public class J05030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> list = new ArrayList<>();
        while(n-- > 0) {
            list.add(new SinhVien(sc.nextLine(),sc.nextLine(),sc.nextLine(),
                    Double.parseDouble(sc.nextLine()),Double.parseDouble(sc.nextLine()),Double.parseDouble(sc.nextLine())));
        } 
        Collections.sort(list,(x,y) -> { return x.getMa().compareTo(y.getMa());});
        for(int i=0 ; i<list.size() ; i++) {
            System.out.println(i+1 + " " + list.get(i));
        }
    }
}