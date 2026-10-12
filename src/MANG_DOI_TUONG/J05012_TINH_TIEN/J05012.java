
package MANG_DOI_TUONG.J05012_TINH_TIEN;
import java.util.*;

public class J05012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MatHang> list = new ArrayList<>();
        while(n-- > 0) {
            String ma = sc.nextLine(),ten = sc.nextLine();
            long soLuongMua = Long.parseLong(sc.nextLine()),
                    donGia = Long.parseLong(sc.nextLine()),
                    chietKhau = Long.parseLong(sc.nextLine());
            MatHang mh = new MatHang(ma,ten,soLuongMua,donGia,chietKhau);
            list.add(mh);
        }
        Collections.sort(list, new Comparator<MatHang>() {
            public int compare(MatHang x, MatHang y) {
                return Long.compare(y.tongTien(),x.tongTien());
            }
        });
        for(MatHang x : list) System.out.println(x);
        sc.close();
    }
}
