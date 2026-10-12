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
public class j01011 {
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a%b);
    }
    public static long lcm(long a, long b) {
        if(a == 0 || b == 0) return 0;
        return (a/gcd(a,b)) * b;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            long a = sc.nextLong(), b = sc.nextLong();
            System.out.println(lcm(a,b) + " " + gcd(a,b) + "\n");
        }
        sc.close();
    }
}
