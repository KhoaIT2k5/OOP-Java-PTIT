package MANG;

import java.util.Scanner;

public class BO_SUNG_DAY_SO_J02034 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int maxx = 0, ok = 0;
        int[] b = new int[202];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            b[a[i]]++;
            maxx = Math.max(maxx, a[i]);
        }
        for (int i = 1; i <= maxx; i++)
            if (b[i] == 0) {
                ok = 1;
                System.out.println(i);
            }
        if (ok == 0)
            System.out.println("Excellent!");
        scan.close();
    }
}
