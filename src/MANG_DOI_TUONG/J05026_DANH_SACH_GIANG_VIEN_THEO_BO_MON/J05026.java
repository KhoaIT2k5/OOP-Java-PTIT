package MANG_DOI_TUONG.J05026_DANH_SACH_GIANG_VIEN_THEO_BO_MON;

import java.util.*;

class GiangVien {
    private String ma, hoTen, boMon, tenBoMonDayDu;
    public static int stt = 1;
    public GiangVien(String ten, String boMon) {
        this.ma = String.format("GV%02d",stt++);
        this.hoTen = ten;
        this.boMon = maBoMon(boMon);
        this.tenBoMonDayDu = boMon;
    }
    public String getBoMon() {
        return boMon;
    }
    public String getTenBoMonDayDu() {
        return tenBoMonDayDu;
    }
    public static String maBoMon(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            sb.append(st.nextToken().charAt(0));
        }
        return sb.toString().toUpperCase();
    }
    public String ten() {
        StringTokenizer st = new StringTokenizer(this.hoTen);
        String ten = "";
        while(st.hasMoreTokens()) ten = st.nextToken();
        return ten;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.hoTen + " " + this.boMon;
    }
}
public class J05026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GiangVien> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            list.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-->0) {
            String tenBoMon = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN BO MON " + GiangVien.maBoMon(tenBoMon) + ":");
            for(GiangVien x : list) 
                if(tenBoMon.equals(x.getTenBoMonDayDu()))System.out.println(x);
        }
        sc.close();
    }
}
