package MANG_DOI_TUONG.J05065_LIET_KE_NHAN_VIEN_THEO_NHOM;
import java.util.*;
class NhanVien {
    private String ma, ten;
    public NhanVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
    public void setMaChucVu() {
        String tmp = this.ma.substring(2);
        this.ma = "NV" + tmp;
    }
    public String maChucVu() {
        return this.ma.substring(0,2);
    }
    public String bacLuong() {
        return this.ma.substring(2,4);
    }
    public String soHieuNV() {
        return this.ma.substring(4);
    }
    @Override
    public String toString() {
        return this.ten + " " + maChucVu() + " " + soHieuNV() + " " + bacLuong();
    }
}
public class J05065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int cntTP = 0, cntPP = 0, cntGD = 0;
        ArrayList<NhanVien> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            String s = sc.nextLine();
            String[] arr = s.trim().split("\\s+");
            String ma = arr[0], ten = "";
            for(int j=1 ; j<arr.length ; j++) {
                ten = ten + arr[j];
                if(j!= arr.length-1) ten = ten + " ";
            } 
            NhanVien nv = new NhanVien(ma,ten);
            if(nv.maChucVu().equals("TP")){
                if(cntTP < 3) cntTP++; else nv.setMaChucVu();                
            } else if(nv.maChucVu().equals("PP")) {
                if(cntPP < 3) cntPP++; else nv.setMaChucVu();
            } else if(nv.maChucVu().equals("GD")){
                if(cntGD < 1) cntGD++; else nv.setMaChucVu();
            }
            list.add(nv);
        }
        Collections.sort(list,(x,y) -> {
           if(!y.bacLuong().equals(x.bacLuong())) return y.bacLuong().compareTo(x.bacLuong());
           return x.soHieuNV().compareTo(y.soHieuNV());
        });
        int q = sc.nextInt();
        while(q-- > 0) {
            String s = sc.next();
            for(NhanVien x : list) if(s.equals(x.maChucVu())) System.out.println(x);
            System.out.println();
        }
        sc.close();
    }
}
