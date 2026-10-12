
package MANG_DOI_TUONG.J05010_SAP_XEP_DANH_SACH_MAT_HANG;

import java.util.*;

public class J05010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MatHang> mh = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            int ma = i;
            String ten = sc.nextLine(), loai = sc.nextLine();
            double mua = Double.parseDouble(sc.nextLine()), ban = Double.parseDouble(sc.nextLine());
            MatHang tmp = new MatHang(ten,loai,ma,mua,ban);
            mh.add(tmp);
        }
        Collections.sort(mh,(MatHang x, MatHang y) -> {
           return Double.compare(y.loiNhuan(), x.loiNhuan());
        });
        for(int i=0 ; i<n ; i++) System.out.println(mh.get(i));
        sc.close();
    }
}
