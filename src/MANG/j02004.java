import java.util.Scanner;


public class j02004 {
    public static int check(int a[], int n) {
        int left = 0, right = n-1;
        while(left <= right) {
            if(a[left] != a[right]) return 0;
            left++; right--;
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int [n];
            for(int i=0 ; i<n ; i++) a[i] = sc.nextInt();
            if(check(a, n) == 1) System.out.println("YES"); else System.out.println("NO"); 
        }
        sc.close();
    }
}
