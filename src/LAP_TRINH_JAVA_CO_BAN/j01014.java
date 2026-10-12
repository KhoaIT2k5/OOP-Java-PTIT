package LAP_TRINH_JAVA_CO_BAN;

import java.util.Scanner;

public class j01014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            long res = -1;
            for(int i=2 ; i <= Math.sqrt(n); i++) {
                if(n%i == 0) {
                    res = Math.max(res,i);
                    while(n % i == 0) n = n/i;
                }
            }
            if(n > 1) res = Math.max(res, n);
            System.out.println(res);
        }
        sc.close();
    }
}
