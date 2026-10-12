package VAO_RA_FILE.J07060_SAP_XEP_LICH_THI;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class MonHoc {
    private String ma,ten,hinhThuc;

    public MonHoc(String ma, String ten, String hinhThuc) {
        this.ma = ma;
        this.ten = ten;
        this.hinhThuc = hinhThuc;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
    
}
class CaThi {
    private String ma,phong;
    private Date ngay,gio;
    private static int stt = 1;
    private  SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private  SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
    public CaThi(String ngay, String gio,String phong) throws ParseException {
        this.ma = String.format("C%03d",stt++);
        this.phong = phong;
        this.ngay = sdf1.parse(ngay);
        this.gio = sdf2.parse(gio);
    }

    public String getMa() {
        return ma;
    }

    public String getPhong() {
        return phong;
    }

    public Date getNgay() {
        return ngay;
    }

    public Date getGio() {
        return gio;
    }
    
}
class LichThi {
    private CaThi caThi;
    private MonHoc monHoc;
    private String maNhom;
    private int soSV;
    private final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
    public LichThi(CaThi caThi, MonHoc monHoc, String maNhom, int soSV) {
        this.caThi = caThi;
        this.monHoc = monHoc;
        this.maNhom = maNhom;
        this.soSV = soSV;
    }

    public CaThi getCaThi() {
        return caThi;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public String getMaNhom() { 
        return maNhom;
    }

    public int getSoSV() {
        return soSV;
    }
    
    @Override
    public String toString() {
        return sdf1.format(this.caThi.getNgay())  + " "  + sdf2.format(this.caThi.getGio())
                + " " + this.caThi.getPhong() + " " + this.monHoc.getTen() + " " + this.maNhom
                + " " + this.soSV;
    }
}
public class J07060 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("MONTHI.in"));
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String,MonHoc> map1 = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            MonHoc mh = new MonHoc(sc.nextLine(),sc.nextLine(),sc.nextLine());
            map1.put(mh.getMa(), mh);
        }
        
        Scanner sc2 = new Scanner(new File("CATHI.in"));
        int m = Integer.parseInt(sc2.nextLine());
        HashMap<String,CaThi> map2 = new HashMap<>();
        for(int i=0 ; i<m ; i++) {
            CaThi ct = new CaThi(sc2.nextLine(),sc2.nextLine(),sc2.nextLine());
            map2.put(ct.getMa(), ct);
        }
        
        Scanner sc3 = new Scanner(new File("LICHTHI.in"));
        int k = sc3.nextInt();
        ArrayList<LichThi> list = new ArrayList<>();
        for(int i=0 ; i<k ; i++) {
            String maCT = sc3.next(), maMon = sc3.next(), maNhom = sc3.next();
            int soSV = sc3.nextInt();
            LichThi lt = new LichThi(map2.get(maCT),map1.get(maMon),maNhom,soSV);
            list.add(lt);
        }
        
        Collections.sort(list, new Comparator<LichThi>() {
           @Override
           public int compare(LichThi x, LichThi y) {
               long gio1 = x.getCaThi().getGio().getTime(),
                    gio2 = y.getCaThi().getGio().getTime(),
                    ngay1 = x.getCaThi().getNgay().getTime(),
                    ngay2 = y.getCaThi().getNgay().getTime();
               if(ngay1 == ngay2) {
                   if(gio1 == gio2) return x.getCaThi().getMa().compareTo(y.getCaThi().getMa());
                   return Long.compare(gio1,gio2);
               }
               return Long.compare(ngay1,ngay2);
           }
        });
        
        for(LichThi x : list) System.out.println(x);
    }
}




//2
//MUL1320
//Nhap mon da phuong tien
//Bai tap lon + Van dap truc tuyen
//BAS1203
//Giai tich 1
//Thi viet + Van dap truc tuyen
//2
//09/01/2022
//15:30
//70172
//09/01/2022
//10:00
//70279
//2
//C001 MUL1320 01 46
//C002 BAS1203 04 72