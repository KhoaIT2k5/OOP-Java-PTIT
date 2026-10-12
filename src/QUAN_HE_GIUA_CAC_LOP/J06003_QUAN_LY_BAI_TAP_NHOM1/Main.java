package QUAN_HE_GIUA_CAC_LOP.J06003_QUAN_LY_BAI_TAP_NHOM1;
import java.util.*;
class SinhVien {
    private String ma,ten,sdt;
    private int sttNhom;

    public SinhVien(String ma, String ten, String sdt, int sttNhom) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.sttNhom = sttNhom;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSttNhom() {
        return sttNhom;
    }

    public void setSttNhom(int sttNhom) {
        this.sttNhom = sttNhom;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.sdt;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();     
        sc.nextLine();
        ArrayList<SinhVien> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            list.add(new SinhVien(sc.nextLine(),sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine())));
        }
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0 ; i<m ; i++) {
            String deTai = sc.nextLine();
            map.put(i+1,deTai);
        }
        int q = sc.nextInt(); while(q-- > 0) {
            int nhom = sc.nextInt();
            System.out.println("DANH SACH NHOM " + nhom + ":");
            for(SinhVien x : list) if(x.getSttNhom() == nhom) System.out.println(x);
            System.out.println("Bai tap dang ky: " + map.get(nhom));
        }
        sc.close();
    }
}
