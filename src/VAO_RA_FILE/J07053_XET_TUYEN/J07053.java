package VAO_RA_FILE.J07053_XET_TUYEN;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
class PhuHo {
    private String ma,ten,ns;
    private double lt, th;
    public static int stt = 1;
    public PhuHo(String ten, String ns, double lt, double th) {
        this.ma = "PH" + String.format("%02d", stt++);
        this.ten = chuanHoa(ten);
        this.ns = ns;
        this.lt = lt;
        this.th = th;
    }
    public String chuanHoa(String s) {
        String[] a = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<a.length ; i++) {
            sb.append(a[i].substring(0,1).toUpperCase())
                    .append(a[i].substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }
    public String getMa() {
        return ma;
    }
    public int tuoi() {
        return 2021 - Integer.parseInt(this.ns.substring(this.ns.length()-4));
    }
    public double getTb() {
        return (this.lt + this.th)/2;
    }
    public double getThuong() {
        if(this.th >= 8.0 && this.lt >= 8.0) return 1;
        else if(this.th >= 7.5 && this.lt >= 7.5) return 0.5;
        return 0;
    }
    public long getDiemXepLoai() {
        if((getTb() + getThuong()) <= 10.0) return Math.round(getTb() + getThuong());
        return 10;
    }
    public String xepLoai() {
        long tb = getDiemXepLoai();
        if (tb >= 9) return "Xuat sac";
        else if (tb == 8) return "Gioi";
        else if (tb == 7) return "Kha";
        else if (tb >= 5) return "Trung binh";
        else return  "Truot";
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + tuoi() + " " + getDiemXepLoai() + " " + xepLoai();
    }
}
public class J07053 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("XETTUYEN.in")).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<PhuHo> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new PhuHo(sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble()));
        }
//        Collections.sort(a,(x,y) -> {
//            if(x.getDiemXepLoai() != y.getDiemXepLoai())
//                return Long.compare(y.getDiemXepLoai(),x.getDiemXepLoai());
//            return x.getMa().compareTo(y.getMa());
//        });
        for (PhuHo x : a) System.out.println(x);
        sc.close();
    }
}
