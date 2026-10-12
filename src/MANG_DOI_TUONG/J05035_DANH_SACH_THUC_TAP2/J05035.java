package MANG_DOI_TUONG.J05035_DANH_SACH_THUC_TAP2;
import java.util.*;
class SinhVien {
    private String ma,ten,lop,mail,doanhNghiep;
    private int stt;
    public static int cnt = 1;

    public SinhVien(String ma, String ten, String lop, String mail, String doanhNghiep) {
        this.stt = cnt++;
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.mail = mail;
        this.doanhNghiep = doanhNghiep;
    }

    public String getMa() {
        return ma;
    }
    public String getDoanhNghiep() {
        return doanhNghiep;
    }
    @Override 
    public String toString() {
        return this.stt + " " + this.ma + " " + this.ten + " " 
                + this.lop + " " + this.mail + " " + this.doanhNghiep;
    }
}
public class J05035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            String ma = sc.nextLine(),ten = sc.nextLine(),
                   lop = sc.nextLine(), mail = sc.nextLine(), doanhNghiep = sc.nextLine();
            list.add(new SinhVien(ma,ten,lop,mail,doanhNghiep));
        }
        Collections.sort(list,(x,y) -> {
            return x.getMa().compareTo(y.getMa());
        });
        int q = sc.nextInt(); while(q-- > 0) {
            String business = sc.next();
            for(SinhVien x : list) 
                if(business.equals(x.getDoanhNghiep())) System.out.println(x);     
        }
        sc.close();
    }
}
