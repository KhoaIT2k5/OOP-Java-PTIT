
package KIEMTRA;

import java.util.*;
class NhanVien {
    private String ten, chucVu;
    private int ngayCong;
    private long lcb;

    public NhanVien() {
    }
    public void input(Scanner in) {
        this.ten = chuanHoa(in.nextLine());
        this.lcb = Long.parseLong(in.nextLine());
        this.ngayCong = Integer.parseInt(in.nextLine());
        this.chucVu = in.nextLine();
    }
    public double getPhuCap(String chucVu) {
        if(chucVu.equals("GD")) return 250000;
        if(chucVu.equals("PGD")) return 200000;
        if(chucVu.equals("TP")) return 180000;
        return 150000;
    }
    public double getLuongThang() { return this.lcb * this.ngayCong;}
    public double getThuong() {
        double luongChinh = getLuongThang();
        if(this.ngayCong >= 25) return luongChinh * 0.2;
        if(this.ngayCong >= 22 && this.ngayCong < 25) return luongChinh * 0.1;
        return 0;
    }  
    
    public double getThuNhap(int soNgay) {
        return getLuongThang() + getThuong() + getPhuCap(this.chucVu);
    }

    public String chuanHoa(String s) {
        String[] arr = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String x : arr) {
            sb.append(x.substring(0,1).toUpperCase()).append(x.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
    @Override
    public String toString() {
        return this.ten + " " 
                + String.format("%.1f",this.getLuongThang()) + " " 
                +  String.format("%.1f",this.getPhuCap(this.chucVu)) + " " 
                +  String.format("%.1f",this.getThuNhap(this.ngayCong));
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        NhanVien nv = new NhanVien();
        nv.input(in);       
        System.out.println(nv);
    }
}


