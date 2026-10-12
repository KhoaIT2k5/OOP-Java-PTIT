
package MANG_DOI_TUONG.J05013_TUYEN_DUNG;

import java.util.*;

public class J05013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<NhanVien> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            String ten = sc.nextLine(), lt = sc.nextLine(), th = sc.nextLine();
            NhanVien nv = new NhanVien(ten,lt,th);
            list.add(nv);
        }
        Collections.sort(list, new Comparator<NhanVien>() {
            public int compare(NhanVien x, NhanVien y) {
                return Double.compare(y.getTb(), x.getTb());
            }
        });
        for(NhanVien x : list) System.out.println(x);
        sc.close();
    }
}
