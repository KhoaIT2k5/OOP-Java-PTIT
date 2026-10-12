package MANG;

import java.util.HashSet;
import java.util.Scanner;

public class DAY_CON_LIEN_TIEP_CO_TONG_BANG_K_J02028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();
            if (checkWithHashSet(a, n, k)) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }

    public static boolean checkWithHashSet(long[] a, int n, long k) {
        HashSet<Long> set = new HashSet<>();
        set.add(0L);
        long current_prefix_sum = 0;
        for (int i = 0; i < n; i++) {
            current_prefix_sum += a[i];
            if (set.contains(current_prefix_sum - k)) return true;
            set.add(current_prefix_sum);
        }
        return false;
    }
}
