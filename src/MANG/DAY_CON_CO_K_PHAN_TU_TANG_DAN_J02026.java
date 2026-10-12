package MANG;

import java.util.Arrays;
import java.util.Scanner;

public class DAY_CON_CO_K_PHAN_TU_TANG_DAN_J02026 {

    public static boolean sinh(int n, int k, int b[]) {
        int i = k;
        while(i > 0 && b[i] == n-k+i) i--;
        if(i == 0) return false; else {
            b[i]++;
            for(int j = i+1 ; j<=k ; j++) b[j] = b[j-1] + 1;
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int a[] = new int [n+1];
            for(int i=1 ; i<=n ; i++) a[i] = sc.nextInt();
            Arrays.sort(a, 1, n+1);

            int b[] = new int [n+1];
            for(int i=1 ; i<=k ; i++) b[i] = i;
            boolean ok = true;

            while(ok == true) {
                for(int i=1 ; i<=k ; i++) System.out.print(a[b[i]] + " ");
                System.out.println();
                ok = sinh(n,k,b);
            }
        }
        sc.close();
    }
}

