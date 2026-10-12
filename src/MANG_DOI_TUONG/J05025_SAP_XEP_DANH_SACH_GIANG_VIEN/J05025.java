package MANG_DOI_TUONG.J05025_SAP_XEP_DANH_SACH_GIANG_VIEN;

import java.util.*;

class GiangVien {
    private String ma, hoTen, boMon;
    public static int stt = 1;
    public GiangVien(String ten, String boMon) {
        this.ma = String.format("GV%02d",stt++);
        this.hoTen = ten;
        this.boMon = boMon;
    }
    public String maBoMon() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(this.boMon);
        while(st.hasMoreTokens()) {
            sb.append(st.nextToken().charAt(0));
        }
        return sb.toString().toUpperCase();
    }
    public String getMa() {
        return ma;
    }
    public String ten() {
        StringTokenizer st = new StringTokenizer(this.hoTen);
        String ten = "";
        while(st.hasMoreTokens()) ten = st.nextToken();
        return ten;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.hoTen + " " + maBoMon();
    }
}
public class J05025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GiangVien> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            list.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(list, (x,y) -> {
            if(x.ten().equals(y.ten())) return x.getMa().compareTo(y.getMa());
            return x.ten().compareTo(y.ten());
        });
        for(GiangVien x : list) System.out.println(x);
        sc.close();
    }
}
