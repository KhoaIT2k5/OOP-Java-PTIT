
package MANG_DOI_TUONG.J05005_DANH_SACH_DOI_TUONG_SINH_VIEN3;

import java.util.StringTokenizer;


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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    private static String chuanHoaNS(String ns) {
       StringTokenizer st = new StringTokenizer(ns,"/");
       return String.format("%02d/%02d/%04d",
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
       );
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
