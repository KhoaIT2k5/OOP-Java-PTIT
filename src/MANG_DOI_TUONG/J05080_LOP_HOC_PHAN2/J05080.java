package MANG_DOI_TUONG.J05080_LOP_HOC_PHAN2;
import java.util.*;
class HocPhan {
    private String maMon,tenMon,nhomLop,giangVien;
    public HocPhan(String maMon, String tenMon, String nhomLop, String giangVien) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.nhomLop = nhomLop;
        this.giangVien = giangVien;
    }
    public String getMaMon() {
        return maMon;
    }
    public String getTenMon() {
        return tenMon;
    }
    public String getNhomLop() {
        return nhomLop;
    }
    public String getGiangVien() {
        return giangVien;
    }
    @Override
    public String toString() {
        return this.maMon + " " + this.tenMon + " " + this.nhomLop;
    }
}
public class J05080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<HocPhan> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            HocPhan hp = new HocPhan(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
            list.add(hp);
        }
        Collections.sort(list,(x,y) -> {
            if(!x.getMaMon().equals(y.getMaMon())) return x.getMaMon().compareTo(y.getMaMon());
            return x.getNhomLop().compareTo(y.getNhomLop());
        }); 
        int q = sc.nextInt(); sc.nextLine();
        while(q-- > 0) {
            String giangVien = sc.nextLine();
            System.out.println("Danh sach cho giang vien " + giangVien + ":");
            for(HocPhan x : list) 
                if(x.getGiangVien().equals(giangVien)) System.out.println(x);
        }
        sc.close();
    }
}
