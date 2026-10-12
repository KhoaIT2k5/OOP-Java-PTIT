

import java.util.Scanner;

public class BOI_SO_NHO_NHAT_CUA_N_SO_NGUYEN_DUONG_DAU_TIEN_J02008 {
    public static long ucln(long a, long  b) {
        if(b == 0) return a;
        return ucln(b,a%b);
    }
    public static long  bcnn(long a, long b) {
        return a*b/ucln(a,b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong(), s = 1;
            for(int i=1 ; i<=n ; i++) s = bcnn(s,i);
            System.out.println(s);
        }
        sc.close();
    }
}
