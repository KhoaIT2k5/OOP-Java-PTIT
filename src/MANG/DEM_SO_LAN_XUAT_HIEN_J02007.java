package MANG;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DEM_SO_LAN_XUAT_HIEN_J02007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j = 1 ; j<=t ; j++) {

            int n = sc.nextInt();
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
            for(int i=0 ; i<n ; i++) {
                int x = sc.nextInt();
                if(map.containsKey(x)) map.put(x, map.get(x) + 1);
                else map.put(x, 1);
            }
            System.out.println("Test " + j + ":");
            for(Map.Entry<Integer, Integer> entry: map.entrySet())
                System.out.println(entry.getKey() +  " xuat hien " + entry.getValue() + " lan");
        }
        sc.close();
    }
}
