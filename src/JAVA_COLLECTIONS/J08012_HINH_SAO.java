/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JAVA_COLLECTIONS;

import java.util.*;
public class J08012_HINH_SAO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> degree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            degree.put(u, degree.getOrDefault(u, 0) + 1);
            degree.put(v, degree.getOrDefault(v, 0) + 1);
        }
        boolean ok = false;
        for (Map.Entry<Integer,Integer> entry : degree.entrySet()) {
            if (entry.getValue() == n - 1) {
                ok = true;
                break;
            }
        }
        if (ok) System.out.println("Yes");
        else System.out.println("No");
        sc.close();
    }
}
