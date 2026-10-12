package MANG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DAY_CON_CO_TONG_NGUYEN_TO_J02025 {
    static int n, ok;
    static int[] a;

    public static void create() {
        for (int i = 1; i <= n; i++) a[i] = 0;
    }

    public static void sinh() {
        int i = n;
        while (i > 0 && a[i] == 1) {
            a[i] = 0;
            i--;
        }
        if (i > 0) a[i] = 1; else ok = 0;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                n = sc.nextInt();
                int[] b = new int[n + 1];
                for (int i = 1; i <= n; i++) b[i] = sc.nextInt();

                Arrays.sort(b, 1, n + 1);
                a = new int[n + 1];
                create(); ok = 1;

                ArrayList<ArrayList<Integer>> res = new ArrayList<>();
                while (ok == 1) {
                    int sum = 0;
                    ArrayList<Integer> kq = new ArrayList<>();
                    for (int i = n; i >= 1; i--) {
                        if (a[i] == 1) {
                            sum += b[i];
                            kq.add(b[i]);
                        }
                    }
                    if (isPrime(sum) && !kq.isEmpty()) res.add(kq);
                    sinh();
                }
                Collections.sort(res, (x, y) -> {
                    int len = Math.min(x.size(), y.size());
                    for (int i = 0; i < len; i++) if (!x.get(i).equals(y.get(i))) return x.get(i) - y.get(i);
                    return x.size() - y.size();
                });

                // In kết quả
                for (ArrayList<Integer> list : res) {
                    for (int x : list) System.out.print(x + " ");
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}