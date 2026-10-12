package VAO_RA_FILE.J07036_BANG_DIEM_THEO_LOP;

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

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public double getDiem() {
        return diem;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    @Override
    public String toString() {
        int formatDiem = (int) this.diem;
        if(formatDiem == this.diem)
            return this.sinhVien.getMa() + " " + this.sinhVien.getTen() + " "
                    + this.monHoc.getMa() + " " + this.monHoc.getTen () + " " + (int) this.diem;
        else {
            return this.sinhVien.getMa() + " " + this.sinhVien.getTen() + " "
                    + this.monHoc.getMa() + " " + this.monHoc.getTen () + " " + this.diem;
        }
    }
}
public class J07036 {
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
            if(x.getMonHoc().getMa().equals(y.getMonHoc().getMa()))
                return x.getSinhVien().getMa().compareTo(y.getSinhVien().getMa());
            return x.getMonHoc().getMa().compareTo(y.getMonHoc().getMa());
        });
        int q = sc3.nextInt();
        while(q-- > 0) {
            String s = sc3.next();
            System.out.println("BANG DIEM lop " + s + ":");
            for(BangDiem x : list3)
                if(x.getSinhVien().getLop().equals(s)) System.out.println(x);
        }
        sc.close();
        sc3.close();
        sc2.close();
    }
}


/*

2
B15DCKT150
NGUYEN NGOC SON
D15CQKT02-B
sv3@stu.ptit.edu.vn
B15DCKT199
NguyeN   TrONg Tung
D15CQKT02-B
sv4@stu.ptit.edu.vn
2
INT1155
Tin hoc co so 2
2
SKD1103
Ky nang tao lap Van ban
1
2
B15DCKT150 INT1155 8.5
B15DCKT150 SKD1103 9
1
D15CQKT02-B
 */