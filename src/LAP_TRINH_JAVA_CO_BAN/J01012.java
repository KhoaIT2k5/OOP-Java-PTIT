package LAP_TRINH_JAVA_CO_BAN;

import java.util.Scanner;

public class J01012
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt(), cnt = 0;
            for(int i=1 ; i*i <= n ; i++) {
                if(n % i == 0) {
                    if(i % 2 == 0) cnt++;
                    if(i != n/i && (n/i) % 2 == 0) cnt++;
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}
