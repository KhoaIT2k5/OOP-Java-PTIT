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

public class j01018 {
    public static boolean check(long n) {
        long sum = 0, b = -1;
        while(n != 0 ) {
            long a = n % 10;
            if(b != -1) if(Math.abs(b-a) != 2) return false;
            sum = sum + a;
            b = a;
            n = n/10;
        }
        if(sum % 10 == 0) return true;
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            if(check(n)) System.out.println("YES"); else System.out.println("NO");
        }
        sc.close();
    }
}
