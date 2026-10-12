package KIEMTRA;

import java.io.*;
import java.util.*;

class SinhVien {
    private String ma,ten,sdt,email;

    public SinhVien(String ma, String ten, String sdt, String email) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }
    
    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }
    
}
class DeTai {
    private String ma,tenGV,tenDeTai;
    private static int stt=1;

    public DeTai(String tenGV, String tenDeTai) {
        this.ma = String.format("DT%03d",stt++);
        this.tenGV = tenGV;
        this.tenDeTai = tenDeTai;
    }

    public String getMa() {
        return ma;
    }
    
    public String getTenGV() {
        return tenGV;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }
    
}
class HoiDong {
    private SinhVien sinhVien;
    private DeTai detai;
    private String ma;

    public HoiDong(SinhVien sinhVien, DeTai detai, String ma) {
        this.sinhVien = sinhVien;
        this.detai = detai;
        this.ma = ma;
    }
    public String tenHoiDong() {
        return "HOI DONG " + this.ma.substring(2);
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public DeTai getDetai() {
        return detai;
    }

    public String getMa() {
        return ma;
    }
    
    @Override
    public String toString() {
        return "DANH SACH " + tenHoiDong() + ":\n" + this.sinhVien.getMa() + " " + 
                this.sinhVien.getTen() + " " + 
                this.detai.getTenDeTai() + " " + 
                this.detai.getTenGV();
    }
}
public class Bai1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<SinhVien> list = new ArrayList<>();
        HashMap<String,SinhVien> map1 = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            String ma = sc.nextLine(),ten = sc.nextLine(), sdt = sc.nextLine(), mail = sc.nextLine();
            SinhVien sv = new SinhVien(ma,ten,sdt,mail);
            list.add(sv);
            map1.put(ma,sv);
        }
        
        Scanner sc1 = new Scanner(new File("DETAI.in"));
        int m = Integer.parseInt(sc1.nextLine());
        HashMap<String,DeTai> map2 = new HashMap<>();
        for(int i=0 ; i<m ; i++) {
            String ten = sc1.nextLine(), tenDeTai = sc1.nextLine();
            DeTai dt = new DeTai(ten,tenDeTai);
            map2.put(dt.getMa(),dt);
        }
        
        Scanner sc2 = new Scanner(new File("HOIDONG.in"));
        ArrayList<HoiDong>listt = new ArrayList<>();
        int k  = sc2.nextInt();
        for(int i=0 ; i<k ; i++) {
            String maSV= sc2.next(), maDT = sc2.next(), ma = sc2.next();
            HoiDong hd = new HoiDong(map1.get(maSV),map2.get(maDT),ma);
            listt.add(hd);
        }
        Collections.sort(listt,(x,y)->{
            return x.getSinhVien().getMa().compareTo(y.getSinhVien().getMa());
        }) ;
        for(HoiDong x : listt) {
            System.out.println(x);
        }
    }
}
