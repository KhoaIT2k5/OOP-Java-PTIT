/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAP_TRINH_JAVA_CO_BAN;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class j01006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long f[] = new long[94];
            f[0] = 0;
            f[1] = 1;
            for (int i = 2; i <= n; i++)
                f[i] = f[i - 1] + f[i - 2];
            System.out.println(f[n] + "\n");
        }
        sc.close();
    }
}
