

import java.util.Scanner;

public class LIET_KE_TO_HOP_J02020 {

    static int n,k,ok;
    static int[] a = new int[20];

    public static void create(){
        for(int i=1 ; i<=k ; i++) a[i] = i;
    }

    public static void sinh() {
        int i = k;
        while(i > 0 && a[i] == n-k+i) i--;
        if(i == 0) ok = 0;
        else {
            a[i]++;
            for(int j = i+1 ; j<=k ; j++) a[j] = a[j-1] + 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int cnt = 0; ok = 1;
        create();
        while(ok == 1) {
            for(int i=1 ; i<=k ; i++) System.out.print(a[i] + " ");
            System.out.print("\n");
            cnt++;
            sinh();
        }
        System.out.println("\nTong cong co " + cnt + " to hop");
        sc.close();

    }
}
