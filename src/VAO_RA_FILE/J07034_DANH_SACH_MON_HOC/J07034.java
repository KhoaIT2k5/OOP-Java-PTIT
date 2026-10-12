package VAO_RA_FILE.J07034_DANH_SACH_MON_HOC;

import java.util.*;
import java.io.*;

class mon {
    private String ma,mon,tc;

    public mon(String ma, String mon, String tc) {
        this.ma = ma;
        this.mon = mon;
        this.tc = tc;
    }

    public String getMon() {
        return mon;
    }
    @Override
    public String toString() {
        return this.ma + " " + getMon() + " " + this.tc; 
    }
}
public class J07034 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("MONHOC.in"));
            int n = sc.nextInt(); sc.nextLine();
            ArrayList<mon> list = new ArrayList<>();
            for(int i=0 ; i<n ; i++) {
                list.add(new mon(sc.nextLine(),sc.nextLine(),sc.nextLine()));
            }
            Collections.sort(list, new Comparator<mon>(){
                @Override
                public int compare(mon x, mon y) {
                    return x.getMon().compareTo(y.getMon());
                }
            });
            for(mon x : list) System.out.println(x);
            sc.close();
        } catch(Exception e) {}    
    }
}