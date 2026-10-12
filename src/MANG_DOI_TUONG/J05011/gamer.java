
package MANG_DOI_TUONG.J05011;

import java.util.StringTokenizer;

public class gamer {
    private String ma, ten, start, end;

    public gamer(String ma, String ten, String start, String end) {
        this.ma = ma;
        this.ten = ten;
        this.start = start;
        this.end = end;
    }
    
    public int gioChoi() {
        StringTokenizer st1 = new StringTokenizer(this.start,":");
        int minutesStart = (Integer.parseInt(st1.nextToken())*60 + Integer.parseInt(st1.nextToken()));
        
        StringTokenizer st2 = new StringTokenizer(this.end,":");
        int minutesEnd = (Integer.parseInt(st2.nextToken())*60 + Integer.parseInt(st2.nextToken()));
        
        return minutesEnd - minutesStart;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + gioChoi()/60 + " gio " + gioChoi()%60 + " phut ";
    }
}
