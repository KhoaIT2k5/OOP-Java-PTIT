package LAP_TRINH_JAVA_CO_BAN;

import java.util.Scanner;
public class j01008 {
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=1 ; k<=t ; k++) {
            int n = sc.nextInt();
            System.out.printf("Test %d: ",k);
            for(int i=2 ; i*i<=n ; i++) {
                int cnt = 0;
                if(n % i == 0) {
                    while(n % i == 0) {
                        cnt++;
                        n = n/i;
                    }
                    System.out.printf("%d(%d) ",i,cnt);
                }
            }
            if(n > 1) System.out.printf("%d(1)",n);
            System.out.println();
        }
        sc.close();
    }
}
