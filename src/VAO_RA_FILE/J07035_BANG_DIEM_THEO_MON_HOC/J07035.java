package VAO_RA_FILE.J07035_BANG_DIEM_THEO_MON_HOC;

import java.io.*;
import java.util.*;

class SinhVien {
    private String ma,ten,lop,email;
    public SinhVien(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = chuanHoaTen(ten);
        this.email = email;
        this.lop = lop;
    }

    private static String chuanHoaTen(String s) {
        StringTokenizer st = new StringTokenizer(s.toLowerCase());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            String word = st.nextToken();
            sb.append(word.substring(0,1).toUpperCase())
                    .append(word.substring(1));
            if(st.hasMoreTokens()) sb.append(" ");
        }
        return sb.toString();
    }
    public String getMa() {
        return ma;
    }
    public String getTen() {
        return ten;
    }
    public String getLop() {
        return lop;
    }
}
class MonHoc {
    private String ma,ten;
    private int tinChi;

    public MonHoc(String ma, String ten, int tinChi) {
        this.ma = ma;
        this.ten = ten;
        this.tinChi = tinChi;
    }

    public String getTen() {
        return ten;
    }

    public String getMa() {
        return ma;
    }
}
class BangDiem {
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private double diem;

    public BangDiem(SinhVien sinhVien, MonHoc monHoc, double diem) {
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.diem = diem;
    }

    public double getDiem() {
        return diem;
    }
    public String getMaSinhVien() {
        return this.sinhVien.getMa();
    }
    public String getMaMon() {
        return this.monHoc.getMa();
    }
    @Override
    public String toString() {
        int formatDiem = (int) this.diem;
        if(formatDiem == this.diem)
            return getMaSinhVien() + " " + this.sinhVien.getTen() + " "
                    + this.sinhVien.getLop() + " " + (int) this.diem;
        else {
            return getMaSinhVien() + " " + this.sinhVien.getTen() + " "
                    + this.sinhVien.getLop() + " " + this.diem;
        }
    }
}
public class J07035 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String,SinhVien> map1 = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            SinhVien sv = new SinhVien(
                    sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine()
            );
            map1.put(sv.getMa(),sv);
        }

        Scanner sc2 = new Scanner(new File("MONHOC.in"));
        int m = Integer.parseInt(sc2.nextLine());
        HashMap<String,MonHoc> map2 = new HashMap<>();
        for(int i=0 ; i<m ; i++) {
            MonHoc mh = new MonHoc(
                    sc2.nextLine(),sc2.nextLine(),Integer.parseInt(sc2.nextLine())
            );
            map2.put(mh.getMa(),mh);
        }

        Scanner sc3 = new Scanner(new File("BANGDIEM.in"));
        ArrayList<BangDiem> list3 = new ArrayList<>();
        int k = Integer.parseInt(sc3.nextLine());
        for(int i=0 ; i<k ; i++) {
            String maSV = sc3.next(),maMon = sc3.next();
            double diem = sc3.nextDouble();
            list3.add(new BangDiem(map1.get(maSV),map2.get(maMon),diem));
        }
        Collections.sort(list3,(x,y) -> {
            if(x.getDiem() == y.getDiem())
                return x.getMaSinhVien().compareTo(y.getMaSinhVien());
            return Double.compare(y.getDiem(),x.getDiem());
        });
        int q = sc3.nextInt();
        while(q-- > 0) {
            String s = sc3.next();
            System.out.println("BANG DIEM MON " + map2.get(s).getTen() + ":");
            for(BangDiem x : list3)
                if(x.getMaMon().equals(s)) System.out.println(x);
        }
        sc.close();
        sc3.close();
        sc2.close();
    }
}

