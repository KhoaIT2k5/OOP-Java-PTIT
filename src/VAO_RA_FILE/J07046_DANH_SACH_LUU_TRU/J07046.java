package VAO_RA_FILE.J07046_DANH_SACH_LUU_TRU;
import java.io.*;
import java.text.*;
import java.util.*;
class KhachSan implements Comparable<KhachSan> {
    private String ma,ten,phong;
    private Date den,di;

    public KhachSan() {}
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static int stt = 1;
    public void input(Scanner sc) throws ParseException {
        this.ma = String.format("KH%02d",stt++);
        this.ten = sc.nextLine();
        this.phong = sc.nextLine();
        this.den = sdf.parse(sc.nextLine());
        this.di = sdf.parse(sc.nextLine());
    }
    
    public long soNgay() {
        return (di.getTime() - den.getTime())/86400000;
    }
    
    @Override
    public int compareTo(KhachSan o) {
        return Long.compare(o.soNgay(),this.soNgay());
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.phong + " " + soNgay();
    }
}
public class J07046 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int n = Integer.parseInt(sc.nextLine());
        KhachSan[] array = new KhachSan[n];
        for(int i=0 ; i<n ; i++) {
            array[i] = new KhachSan();
            array[i].input(sc);
        }
        Arrays.sort(array);
        for(KhachSan x : array) { System.out.println(x); }
        sc.close();
    }
}

