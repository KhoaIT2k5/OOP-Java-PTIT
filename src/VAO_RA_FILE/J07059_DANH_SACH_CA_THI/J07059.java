package VAO_RA_FILE.J07059_DANH_SACH_CA_THI;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class CaThi {
    private String ma;
    private Date ngay,gio;
    private String phong;
    private static int stt = 1;

    private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        
    public CaThi(String ngay, String gio, String phong) throws ParseException{
        this.ma = String.format("C%03d",stt++);
        this.ngay = sdf1.parse(ngay);
        this.gio = sdf2.parse(gio);
        this.phong = phong;
    }

    public String getMa() {
        return ma;
    }

    public Date getNgay() {
        return ngay;
    }

    public Date getGio() {
        return gio;
    }
    
    @Override
    public String toString() {
        return this.ma + " " + sdf1.format(this.ngay)
                + " " + sdf2.format(this.gio) + " " + this.phong;
    }
}
public class J07059 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("CATHI.in"));
        int n = sc.nextInt(); sc.nextLine();
        CaThi[] a = new CaThi[n];
        for(int i=0 ; i<n ; i++) 
            a[i] = new CaThi(sc.nextLine(),sc.nextLine(),sc.nextLine());
        
        Arrays.sort(a,new Comparator<CaThi>(){
           @Override
           public int compare(CaThi x, CaThi y) {
               long ngay1 = x.getNgay().getTime(), ngay2 = y.getNgay().getTime()
                       ,gio1 = x.getGio().getTime(), gio2 = y.getGio().getTime();
               if(ngay1 != ngay2) return Long.compare(ngay1,ngay2);
               else {
                   if(gio1 != gio2) return Long.compare(gio1,gio2);
                   return -y.getMa().compareTo(x.getMa());
               }
           }
        });
        
        for(CaThi x : a) System.out.println(x);
        sc.close();
    }
}
