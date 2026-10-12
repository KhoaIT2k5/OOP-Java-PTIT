package MANG_DOI_TUONG.J05061_SAP_XEP_KET_QUA_XET_TUYEN;
import java.util.*;
class PhuHo {
    private String ma,ten,ns;
    private double lt, th;
    public static int stt = 1;
    public PhuHo(String ten, String ns, double lt, double th) {
        this.ma = "PH" + String.format("%02d", stt++);
        this.ten = ten;
        this.ns = ns;
        this.lt = lt;
        this.th = th;
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
public class J05061 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<PhuHo> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new PhuHo(sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(a,(x,y) -> {
            if(x.getDiemXepLoai() != y.getDiemXepLoai())
                return Long.compare(y.getDiemXepLoai(),x.getDiemXepLoai());
            return x.getMa().compareTo(y.getMa());
        });
        for (PhuHo x : a) System.out.println(x);
        sc.close();
    }
}
