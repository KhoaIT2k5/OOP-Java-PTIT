package VAO_RA_FILE.J07027_QUAN_LY_BAI_TAP_NHOM;
import java.io.*;
import java.util.*;
class SinhVien {
    private String ma,ten,sdt;
    private int sttNhom;
    private String deTai;
    public SinhVien(String ma, String ten, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getDeTai() {
        return deTai;
    }

    public void setDeTai(String deTai) {
        this.deTai = deTai;
    }
    
    public int getSttNhom() {
        return sttNhom;
    }

    public void setSttNhom(int sttNhom) {
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
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.sdt + " " + this.sttNhom + " " + this.deTai;
    }
}
public class J07027 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        
        int n = sc.nextInt();  
        sc.nextLine();
        ArrayList<SinhVien> list = new ArrayList<>();
        HashMap<String,SinhVien> map1 = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            SinhVien sv = new SinhVien(sc.nextLine(),sc.nextLine(),sc.nextLine());
            list.add(sv);
            map1.put(sv.getMa(),sv); // Lưu đối tượng sinh viên vào mã SV tương ứng
        }
        
        Scanner sc2 = new Scanner(new File("BAITAP.in"));
        int  m = sc2.nextInt(); sc2.nextLine();
        HashMap<Integer,String> map2 = new HashMap<>(); 
        for(int i=0 ; i<m ; i++) {
            String deTai = sc2.nextLine();
            map2.put(i+1,deTai); // Lưu đề tài vào STT nhóm
        }
        
        Scanner sc3 = new Scanner(new File("NHOM.in"));
        for(int i=0 ; i<n ; i++) {
            String ma = sc3.next(); 
            int sttNhom = sc3.nextInt();
            
            // Gọi đối tượng sinh viên tương ứng với mã SV và đặt STT nhóm cho sinh viên đó
            map1.get(ma).setSttNhom(sttNhom); 
            
            /*
                Gọi đối tượng sinh viên tương ứng với mã SV và đưa tên đề tài vào sinh viên đó
                map2.get(sttNhom) : Lấy tên đề tài tương ứng với stt Nhóm.
            */
            map1.get(ma).setDeTai(map2.get(sttNhom));
        }
        
        Collections.sort(list, new Comparator<SinhVien>(){
           @Override
           public int compare(SinhVien x, SinhVien y) {
               return x.getMa().compareTo(y.getMa());
           }
        });
        for(SinhVien x : list) System.out.println(x);
        sc.close();
        sc2.close();
        sc3.close();
    }
}
//5
//B17DTCN001
//Nguyen Chi  Linh
//0987345543
//B17DTCN011
//Vu Viet Thang
//0981234567
//B17DTCN023
//Pham Trong Thang
//0992123456
//B17DTCN022
//Nguyen Van  Quyet
//0977865432
//B17DTCN031
//Ngo Thanh Vien
//0912313111
//2
//Xay dung website ban dien thoai truc tuyen
//Xay dung ung dung quan ly benh nhan Covid-19
//B17DTCN001 1
//B17DTCN011 1
//B17DTCN023 1
//B17DTCN022 2
//B17DTCN031 2