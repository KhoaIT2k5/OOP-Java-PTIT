package LAP_TRINH_JAVA_CO_BAN;

import java.util.Scanner;

public class j01013{
    static int[] prime = new int[10000001];
    public static void era() {
        prime[0] = prime[1] = 1;
        for(int i=2 ; i*i <= 10000000 ; i++) {
            if(prime[i] == 0) {
                for(int j=i*i ; j<=10000000 ; j+=i) {
                    prime[j] = 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        era();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),sum = 0;
        while(n-- > 0) {
            int x = sc.nextInt();
            // Calculate the sum of divisors of x
            for (int i = 1; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    sum += i;
                    if (i != x / i) {
                        sum += x / i;
                    }
                }
            }
            
        }   
        System.out.println(sum);
        sc.close();
    }
}