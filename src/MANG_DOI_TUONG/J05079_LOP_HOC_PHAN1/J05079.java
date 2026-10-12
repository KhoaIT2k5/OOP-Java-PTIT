package MANG_DOI_TUONG.J05079_LOP_HOC_PHAN1;
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
        return this.nhomLop + " " + this.giangVien;
    }
}
public class J05079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<HocPhan> list = new ArrayList<>();
        HashMap<String,HocPhan> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            HocPhan hp = new HocPhan(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
            list.add(hp);
            map.put(hp.getMaMon(),hp);
        }
        Collections.sort(list,(x,y) -> {
            return x.getNhomLop().compareTo(y.getNhomLop());
        }); 
        int q = sc.nextInt();
        while(q-- > 0) {
            String maMon = sc.next();
            System.out.println("Danh sach nhom lop mon " + map.get(maMon).getTenMon() + ":");
            for(HocPhan x : list) 
                if(x.getMaMon().equals(maMon)) System.out.println(x);
        }
        sc.close();
    }
}
