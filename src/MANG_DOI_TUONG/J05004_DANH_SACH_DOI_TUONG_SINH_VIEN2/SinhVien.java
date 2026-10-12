/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MANG_DOI_TUONG.J05004_DANH_SACH_DOI_TUONG_SINH_VIEN2;

import java.util.StringTokenizer;

/**
 *
 * @author ADMIN
 */
public class SinhVien {
    private String ten, lop, ns, ma;
    private double gpa;
    public static int stt = 1;
    public SinhVien(String ten, String lop, String ns, double gpa) {
        this.ma = "B20DCCN" + String.format("%03d", stt++);
        this.ten = chuanHoaTen(ten);
        this.lop = lop;
        this.ns = chuanHoaNS(ns);
        this.gpa = gpa;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    private static String chuanHoaNS(String ns) {
        String[] arr = ns.trim().split("/");
        return String.format("%02d/%02d/%04d", Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]) );
    }
    private static String chuanHoaTen(String ten) {
        StringTokenizer st = new StringTokenizer(ten.toLowerCase());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String tu = st.nextToken();
            sb.append(Character.toUpperCase(tu.charAt(0))).append(tu.substring(1));
            if (st.hasMoreTokens()) sb.append(" ");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return this.ma + " " +
               this.ten + " " +
               this.lop + " " +
               this.ns + " " +
               String.format("%.2f", this.gpa);
    }
}