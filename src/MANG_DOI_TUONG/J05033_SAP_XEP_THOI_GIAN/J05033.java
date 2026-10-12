
package MANG_DOI_TUONG.J05033_SAP_XEP_THOI_GIAN;
import java.util.*;
class Time {
    private int h,m,s;

    public Time(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }
    public int getH() {
        return h;
    }
    public int getM() {
        return m;
    }
    public int getS() {
        return s;
    }
    @Override
    public String toString() {
        return this.h + " " + this.m + " " + this.s; 
    }
}
public class J05033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) list.add(new Time(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        Collections.sort(list,(x,y) -> {
            if(x.getH() == y.getH()) {
                if(x.getM() == y.getM()) return x.getS() - y.getS();
                else return x.getM() - y.getM();
            } else return x.getH() - y.getH();
        });
        for(Time x : list) System.out.println(x);
        sc.close();
    }
}
