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
public class j01017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            long b = -1, ok = 1;
            while(n != 0) {
                long a = n%10;
                if(b != -1) {
                    if(Math.abs(a-b) != 1) {
                        ok = 0;
                        break;
                    }
                }
                b = a;
                n = n/10;
            }
            if(ok == 0) System.out.println("NO"); else System.out.println("YES");
        }
        sc.close();
    }
}
