package MANG_DOI_TUONG.J05013_TUYEN_DUNG;

import java.util.*;
class NhanVien {
    private String ma,ten,loai;
    private double lt, th, tb;

    public static int stt = 1;
    public NhanVien(String ten, String lt, String th) {
        this.ma = "TS" + String.format("%02d", stt++);
        this.ten = ten;
        this.lt = trans(lt);
        this.th = trans(th);
        this.tb = (trans(lt) + trans(th))/2;
        this.loai = xepLoai(tb);
    }

    private static double trans(String lt) {
        String tmp = "";
        if(!lt.contains(".") && !lt.equals("10")) {
            tmp += lt.substring(0,1) + "." + lt.substring(1);
        } else return Double.parseDouble(lt);
        return Double.parseDouble(tmp);
    }
    private static String xepLoai(double tb) {
        if(tb < 5) return "TRUOT";
        else if(tb < 8) return "CAN NHAC";
        else if(tb <= 9.5) return "DAT";
        return "XUAT SAC";
    }

    public double getTb() {
        return tb;
    }

    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + String.format("%.2f", this.tb) + " " + this.loai;
    }
}