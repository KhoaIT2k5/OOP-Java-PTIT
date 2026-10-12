package KIEMTRA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class CongNhan {
    private Date ns,hd;
    private String ma,ten,gt,dc,thue;
    private static int stt = 1;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    public CongNhan(String ten, String gt, String ns, String dc, String thue, String hd) throws ParseException {
        this.ma = String.format("%05d",stt++);
        this.ten = chuanHoa(ten);
        this.gt = gt;
        this.ns = sdf.parse(ns);
        this.dc = dc;
        this.thue = thue;
        this.hd = sdf.parse(hd);
    }
    public static String chuanHoa(String s) {
        String[] arr = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String x : arr) {
            sb.append(x.substring(0,1).toUpperCase()).append(x.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
    public Date getNs() {
        return ns;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.gt + " " 
               + sdf.format(this.ns) + " " + this.dc + " " + this.thue + " " + sdf.format(this.hd);
    }
}
public class Bai5 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<CongNhan> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0 ; i<n ; i++) {
            list.add(new CongNhan(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        Collections.sort(list,(x,y) -> {
            return x.getNs().compareTo(y.getNs());
        });
        for(CongNhan x : list) { System.out.println(x);}
    }
}


//import java.util.*;
//import java.text.*;
//public class Bai5 {
//    static String toD(String s) {
//        String[] d = s.split("/");
//        for (int i = 0; i <= 1; i++) {
//            while (d[i].length() < 2)
//                d[i] = "0" + d[i];
//        }
//        return d[0] + "/" + d[1] + "/" + d[2];
//    }
//    static String stdName(String s) {
//        String[] n = s.toLowerCase().trim().split("\\s+");
//        String r = "";
//        for (int i = 0; i < n.length; i++) {
//            r = r + Character.toString(n[i].charAt(0)).toUpperCase() + n[i].substring(1) + " ";
//        }
//        return r;
//    }
//    static class sv {
//        String code, name, gender, address, date, tax, day;
//        float gpa;
//        public sv(int i, String n, String c, String d, String add, String t, String day) {
//            code = String.format("%05d", i);
//            name = stdName(n);
//            gender = c;
//            date = d;
//            address = add;
//            tax = t;
//            this.day = day;
//        }
//        @Override
//        public String toString() {
//            return code + ' ' + name + gender + ' ' + date + ' ' + address + ' ' + tax + ' ' + day;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<sv> a = new ArrayList<>();
//        int t = sc.nextInt();
//        sc.nextLine();
//        for (int i = 1; i <= t; i++) {
//            a.add(new sv(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
//        }
//        SimpleDateFormat f = new SimpleDateFormat("dd/mm/yyyy");
//        a.sort((sv x, sv y) -> {
//            int c = 0;
//            try{
//                c = f.parse(x.date).compareTo(f.parse(y.date));
//            }catch (ParseException e){
//            }
//            return c;
//        });
//        a.forEach(e -> System.out.println(e));
//    }
//}