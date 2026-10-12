package VAO_RA_FILE.J07002_TINH_TONG;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class J07002 {    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        long sum = 0;
        while(sc.hasNext()) {
            String s = sc.next();
            try {
                int x = Integer.parseInt(s);
                sum += x;
            } catch(Exception e) {}
        }
        System.out.println(sum);
        sc.close();
    }
}
