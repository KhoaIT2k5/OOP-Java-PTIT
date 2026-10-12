package LAP_TRINH_JAVA_CO_BAN;

import java.util.Scanner;

public class j01003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat(), b = sc.nextFloat();
        if(a == 0) {
            if(b != 0) System.out.println("VN"); else System.out.println("VSN");
        }
        else System.out.printf("%.2f", (float)(-b/a));
        sc.close();
    }
}