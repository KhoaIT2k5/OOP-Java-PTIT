package MANG_DOI_TUONG.J05047_BANG_KE_NHAP_KHO_SAP_XEP_THEO_CHIET_KHAU;
import java.util.*;
class MatHang {
    private String ten,ma;
    private long soLuong, donGia;
    public MatHang(String ten, long soLuong, long donGia) {
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public String getMa() {
        StringTokenizer st = new StringTokenizer(this.ten);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(st.hasMoreTokens()) {
            cnt++;
            sb.append(st.nextToken().toUpperCase().charAt(0));
            if(cnt == 2) break;
        }
        return sb.toString() ;
    }
    public void setMa(int stt) {
        this.ma = getMa() + String.format("%02d",stt);
    }
    public long chietKhau() {
        long tongGia = this.soLuong * this.donGia;
        if(this.soLuong > 10) return tongGia * 5/100;
        if(this.soLuong >= 8) return tongGia * 2/100;
        if(this.soLuong >= 5) return tongGia * 1/100;
        return 0;
    }
    public long thanhTien() {
        return this.soLuong * this.donGia - chietKhau();
    }
    @Override
    public String toString() {
        return this.ma + " "  + this.ten + " " + 
                chietKhau() +  " " + thanhTien();
    }
}

public class J05047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<MatHang> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            sc.nextLine();
            list.add(new MatHang(sc.nextLine(),sc.nextLong(),sc.nextLong()));
        }
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for(MatHang x : list) {
            String tmp = x.getMa();
            map.put(tmp,map.getOrDefault(tmp, 0)+1);
            x.setMa(map.get(tmp));
        }
        Collections.sort(list,(x,y) -> {
            return Long.compare(y.chietKhau(),x.chietKhau());
        });
        for(MatHang x : list)  System.out.println(x);
        sc.close();
    }
}