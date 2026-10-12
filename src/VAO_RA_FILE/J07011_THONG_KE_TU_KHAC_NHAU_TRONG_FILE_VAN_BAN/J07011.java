/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VAO_RA_FILE.J07011_THONG_KE_TU_KHAC_NHAU_TRONG_FILE_VAN_BAN;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class J07011 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        int n = sc.nextInt(); 
        sc.nextLine();
        TreeMap<String,Integer> map = new TreeMap<>();
        for(int i=0 ; i<n ; i++) {
            String[] tmp = sc.nextLine().toLowerCase().trim().split("[^a-z0-9]+");
            for(String x : tmp) if(!x.isEmpty()) 
                if(map.containsKey(x)) map.put(x,map.get(x)+1); else map.put(x,1);
        }      
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(Map.Entry<String, Integer> x,Map.Entry<String, Integer> y) -> {
           if(x.getValue().equals(y.getValue())) return x.getKey().compareTo(y.getKey());
           return Integer.compare(y.getValue(), x.getValue()); 
        });
        for(Map.Entry<String,Integer> e : list) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        sc.close();
    }
}
