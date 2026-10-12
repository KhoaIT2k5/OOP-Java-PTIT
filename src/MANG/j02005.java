


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class j02005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int n = sc.nextInt(); int[] a = new int[n];
        int m = sc.nextInt(); int[] b = new int[m];
        for(int i=0 ; i<n ; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        for(int i=0 ; i<m ; i++) {
            b[i] = sc.nextInt();
            if(Arrays.binarySearch(a, b[i]) >= 0) set.add(b[i]);
        }
    for(int x : set) System.out.print(x + " ");
    sc.close();
    }
}
