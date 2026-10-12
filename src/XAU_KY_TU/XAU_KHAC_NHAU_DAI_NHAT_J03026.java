package XAU_KY_TU;

import java.util.Scanner;

public class XAU_KHAC_NHAU_DAI_NHAT_J03026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String a = sc.next(), b = sc.next();
            if(a.length() != b.length()) System.out.println(Math.max(b.length(), a.length()));
            else {
                if(a.equals(b)) System.out.println("-1");
                else System.out.println(a.length());
            }
        }
        sc.close();
    }
}
