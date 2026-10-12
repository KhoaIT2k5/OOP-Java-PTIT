package VAO_RA_FILE.J07057_DIEM_TUYEN_SINH;
import java.util.*;
import java.io.*;
class ThiSinh {
    private String ma,ten,danToc;
    private double diemThi;
    private int khuVuc;
    private static int stt = 1;

    public ThiSinh(String ten,double diemThi,String danToc,int khuVuc) {
        this.ma = String.format("TS%02d",stt++);
        this.ten = chuanHoa(ten);
        this.danToc = danToc;
        this.diemThi = diemThi;
        this.khuVuc = khuVuc;
    }
    public double uuTien() {
        double diemUT = 0;
        if(this.khuVuc == 1) diemUT = diemUT + 1.5;
        if(this.khuVuc == 2) diemUT = diemUT + 1;
        if(!this.danToc.equalsIgnoreCase("Kinh")) diemUT = diemUT + 1.5;
        return diemUT;
    }
    public static String chuanHoa(String s) {
        String[] a = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<a.length ; i++) {
            sb.append(a[i].substring(0,1).toUpperCase())
                    .append(a[i].substring(1).toLowerCase())
                    .append(" ");
        }
        return sb.toString().trim();
    }
    public double tongDiem() {
        return uuTien() + this.diemThi;
    }
    public String trangThai() {
        if(tongDiem() < 20.5) return "Truot";
        return "Do";
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " 
                + String.format("%.1f",tongDiem()) + " " + trangThai();
    }
}
public class J07057 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("THISINH.in"));
        //Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        ThiSinh[] a = new ThiSinh[n];
        for(int i=0 ; i<n ; i++) {
            a[i] = new ThiSinh(sc.nextLine(),Double.parseDouble(sc.nextLine())
                    ,sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }
        Arrays.sort(a,(x,y) -> {
            return Double.compare(y.tongDiem(),x.tongDiem());
        });
        for(ThiSinh x : a) System.out.println(x);
        sc.close();
    }
}
//2
//Nguyen  hong ngat
//22
//Kinh
//1
//  Chu thi MINh
//14
//Dao
//3
