package VAO_RA_FILE.J07072_CHUAN_HOA_VA_SAP_XEP;
import java.util.*;
import java.io.*;
class HoTen {
    private String hoTen,ho,ten,tenDem;
    public HoTen(String hoTen) {
        this.hoTen = chuanHoa(hoTen);
        String[] a = chuanHoa(hoTen).split("\\s+");
        this.ho = a[0];
        this.ten = a[a.length-1];
        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i<a.length-1 ; i++) sb.append(a[i]).append(" ");
        this.tenDem = sb.toString().trim();
    }
    public static String chuanHoa(String s) {
        String[] a = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<a.length ; i++) {
            sb.append(a[i].substring(0,1).toUpperCase()).append(a[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getTenDem() {
        return tenDem;
    }
    
    @Override
    public String toString() {
        return this.hoTen;
    }
}
public class J07072 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        ArrayList<HoTen> list = new ArrayList<>();
        while(sc.hasNextLine()) {
            list.add(new HoTen(sc.nextLine()));
        }
        Collections.sort(list,(x,y) -> {
            if(x.getTen().equals(y.getTen())) {
                if(x.getHo().equals(y.getHo())) return x.getTenDem().compareTo(y.getTenDem());
                return x.getHo().compareTo(y.getHo());
            }
            return x.getTen().compareTo(y.getTen());
        });
        for(HoTen x : list) System.out.println(x);
        sc.close();
    }
}
