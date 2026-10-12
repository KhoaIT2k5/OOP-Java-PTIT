
package MANG_DOI_TUONG.J05004_DANH_SACH_DOI_TUONG_SINH_VIEN2;

import java.util.Scanner;

public class J05004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
