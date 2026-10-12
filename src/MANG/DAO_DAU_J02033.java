package MANG;

import java.util.Arrays;
import java.util.Scanner;

public class DAO_DAU_J02033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                if (a[i] < 0 && k > 0) {
                    a[i] = -a[i];
                    k--;
                }
            }
            Arrays.sort(a);
            if (k % 2 == 1) a[0] = -a[0];
            long sum = 0;
            for (int i = 0; i < n; i++) sum += a[i];
            System.out.println(sum);
        }
        sc.close();
    }
}