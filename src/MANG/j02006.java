

import java.util.Scanner;
import java.util.TreeSet;

public class j02006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        TreeSet<Integer> res = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            res.add(sc.nextInt());
        }
        for(int i = 0; i < m; i++) {
            res.add(sc.nextInt());
        }
        for(int x : res) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}


