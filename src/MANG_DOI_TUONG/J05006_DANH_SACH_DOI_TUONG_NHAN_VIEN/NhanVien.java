/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MANG_DOI_TUONG.J05006_DANH_SACH_DOI_TUONG_NHAN_VIEN;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private String ma,ten,gt,ns,dc,mst,hd;

    public NhanVien(String ma, String ten, String gt, String ns, String dc, String mst, String hd) {
        this.ma = ma;
        this.ten = ten;
        this.gt = gt;
        this.ns = ns;
        this.dc = dc;
        this.mst = mst;
        this.hd = hd;
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " "
                + this.gt + " " + this.ns + " "
                + this.dc + " " + this.mst + " "
                + this.hd;
    }
}
