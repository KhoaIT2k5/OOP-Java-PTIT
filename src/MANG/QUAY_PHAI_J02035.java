package MANG;

import java.util.Scanner;

public class QUAY_PHAI_J02035 {
    public static int check(long a[], int n) {
        for(int i=0 ; i<n-1 ; i++) if(a[i] >= a[i+1]) return i+1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long [n];
            for(int i=0 ; i<n ; i++) a[i] = sc.nextLong();
            System.out.println(check(a,n));
        }
        sc.close();
    }
}
