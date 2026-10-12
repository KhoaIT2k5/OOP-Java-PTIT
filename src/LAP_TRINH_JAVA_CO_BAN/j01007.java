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
public class j01007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        while(t-- > 0) {
            long n = sc.nextLong();
            long a = 0, b = 1, c = 1;
            if(n == 0 || n == 1) System.out.println("YES");
            else {
                while(c < n) {
                    c = a + b;
                    a = b;
                    b = c;
                }
                if(c == n) System.out.println("YES"); else System.out.println("NO");
            }
        }
        sc.close();
    }
}
