package VAO_RA_FILE.J07078_TIM_VI_TRI_XAU_CON;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Main {
//    public static void main(String[] args) throws FileNotFoundException {
//        
//        ArrayList<String> list = new ArrayList<>();
//        list.add("Khoa");
//        list.add("Khoa");
//        list.add("Khoa");
//        list.add("Khoa");
//        PrintWriter pw = new PrintWriter("OUT.txt");
//        for(String x : list) pw.println(x);
//        pw.close();
//    }
    public static int soCS(int n) {
        int cnt = 0;
        while(n != 0) {
            cnt = cnt + 1;
            n = n/10;
        } 
        return cnt;
    }
    public static boolean soTN(int n) {
        int tmp = n,m = 0;
        while(n != 0) {
            m = m* 10 + n%10;
            n = n/10;
        } 
        return tmp == m;
    }
    public static boolean soKG(int n) {
        int b = 10;
        while(n != 0) {
            int a = n%10;
            if(b < a) return false;
            b = a;
            n = n/10;
        } 
        return true;
    }
    public static void main(String[] args) {
        System.out.println(soCS(123456));
        if(soTN(123321)) System.out.println("YES"); else System.out.println("NO");
        if(soKG(123133)) System.out.println("YES"); else System.out.println("NO");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d1 = LocalDate.parse("02/03/2005",dtf);
        LocalDate d2 = LocalDate.parse("09/03/2005",dtf);
        
        long soNgay = ChronoUnit.DAYS.between(d1,d2);
        System.out.println(soNgay);
    }
}
