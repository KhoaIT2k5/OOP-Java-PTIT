package VAO_RA_FILE.J07018_CHUAN_HOA_DANH_SACH_SIINH_VIEN;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class SinhVien {
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
public class J07018  {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String ns = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            SinhVien sv = new SinhVien(ten, lop, ns, gpa);
            System.out.println(sv);
        }
        sc.close();
    }
}