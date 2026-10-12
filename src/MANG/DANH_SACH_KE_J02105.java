package MANG;


import java.util.*;

public class DANH_SACH_KE_J02105  {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x;
        for (int i = 1; i <= n; ++i) {
            System.out.print("List(" + i + ") = ");
            for (int j = 1; j <= n; ++j) {
                x = sc.nextInt();
                if (x == 1) System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
