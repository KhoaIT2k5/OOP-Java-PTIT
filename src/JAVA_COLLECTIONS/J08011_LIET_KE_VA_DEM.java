/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JAVA_COLLECTIONS;

import java.util.*;
public class J08011_LIET_KE_VA_DEM {
    public static boolean check(String s) {
        for(int i=0 ; i<s.length() - 1 ; i++) {
            if(s.charAt(i) > s.charAt(i+1)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        while(sc.hasNext()) {
            String s = sc.next();
            int ok = 1;
            if(check(s)) {
                if(map.containsKey(s)) map.put(s,map.get(s)+1);
                else map.put(s,1);
            }
        }
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(x,y) -> {
            return y.getValue() - x.getValue();
        });
        for(Map.Entry<String, Integer> entry: list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        sc.close();
    }
}
