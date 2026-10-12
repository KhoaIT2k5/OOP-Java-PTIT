package XAU_KY_TU;

import java.util.Scanner;
import java.util.*;

public class TAP_TU_RIENG_CUA_HAI_XAU_J03009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            TreeMap<String, Integer> map = new TreeMap<>();
            String[] a = s1.trim().split("\\s++");
            for(String x : a) map.put(x,1);
            String[] b = s2.trim().split("\\s++");
            for(String x : b) if(map.containsKey(x)) map.put(x,2);
            for(Map.Entry<String, Integer> entry: map.entrySet()) {
                if(entry.getValue() == 1) System.out.print(entry.getKey() + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
