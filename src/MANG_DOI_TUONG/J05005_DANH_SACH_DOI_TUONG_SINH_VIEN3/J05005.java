package MANG_DOI_TUONG.J05005_DANH_SACH_DOI_TUONG_SINH_VIEN3;
import java.util.*;

public class J05005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> sv = new ArrayList<>();
        for(int i = 0 ; i<n ; i++) {
            SinhVien s = new SinhVien(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine(),
                    Double.parseDouble(sc.nextLine())
            );
            sv.add(s);
        }
        Collections.sort(sv, (SinhVien x, SinhVien y) -> {
            return Double.compare(y.getGpa(), x.getGpa());
        });
        for(SinhVien x : sv) System.out.println(x);
        sc.close();
    }
}
