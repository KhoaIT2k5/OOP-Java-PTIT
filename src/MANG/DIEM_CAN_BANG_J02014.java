

import java.util.Scanner;

public class DIEM_CAN_BANG_J02014 {
    public static int check(int a[], int n) {
        int left = 0, right = 0, sum = 0;
        for(int i=0 ; i<n ; i++) sum += a[i];
        for(int i=0 ; i<n ; i++) {
            right = sum - a[i] - left;
            if(left == right) return i+1;
            left = left + a[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int [n];
            for(int i=0 ; i<n ; i++) a[i] = sc.nextInt();
            System.out.println(check(a,n));
        }
        sc.close();
    }
}
