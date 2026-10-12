/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JAVA_COLLECTIONS;
import java.util.*;
public class J08015_CAP_SO_CO_TONG_BANG_K 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            HashMap<Long, Long> map = new HashMap<>();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                ans += map.getOrDefault(k - x, 0L);
                map.put(x, map.getOrDefault(x, 0L) + 1);
            }
            System.out.println(ans);
        }
        sc.close();
    }
}