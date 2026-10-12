package LAP_TRINH_JAVA_CO_BAN;

import java.util.Scanner;

public class j01021 {
    public static  long p = 1000000007;
    public static long pow(long a,long b) {
        if(b == 1) return a%p;
        if(b == 0) return 1;
        long res = 1;
        a = a % p;
        while(b > 0) {
            if(b % 2 == 1) res = (res * a) % p;
            b = b/2;
            a = (a*a)%p;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if(a==0 && b==0) break;
            System.out.println(pow(a,b));
        }
        sc.close();
    }
}
