

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DAY_CON_CO_TONG_LE_J02024 {
    static int n,ok;
    static int a[] = new int [17];

    public static void khoiTao() {
        for (int i = 1; i <= n; i++) a[i] = 0;
    }
    public static void sinh() {
        int i = n;
        while(i > 0 && a[i] == 1) {
            a[i] = 0;
            i--;
        }
        if(i > 0) a[i] = 1; else ok = 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)  {
            n = sc.nextInt(); int b[] = new int [n+1];
            for(int i=1 ; i<=n ; i++) b[i] = sc.nextInt();
            Arrays.sort(b, 1, n + 1);
            khoiTao(); ok = 1;
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            while(ok == 1) {
                int sum = 0;
                ArrayList<Integer> kq = new ArrayList<>();
                for(int i=n ; i>=1 ; i--) {
                    if(a[i] == 1) {
                        sum += b[i];
                        kq.add(b[i]);
                    }
                }
                if(sum % 2 == 1 && !kq.isEmpty()) res.add(kq);
                sinh();
            }
            Collections.sort(res, (x, y) -> {
                int len = Math.min(x.size(), y.size());
                for (int i = 0; i < len; i++) if (!x.get(i).equals(y.get(i))) return x.get(i) - y.get(i);
                return x.size() - y.size();
            });
            for (ArrayList<Integer> list : res) {
                for (int x : list) System.out.print(x + " ");
                System.out.println();
            }
        }
        sc.close();
    }
}
