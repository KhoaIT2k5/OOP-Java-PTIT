package KIEMTRA;

import java.io.*;
import java.util.*;


public class Bai3 {
    public static boolean check(int n) {
        int cnt = 1;
        int a = n%10;
        n = n/10;
        while(n != 0) {
            int b = n%10;
            if(a < b) return false;
            a = b;
            cnt++;
            n = n/10;
        }
        return cnt >= 2;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        ArrayList<Integer> a = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> b = (ArrayList<Integer>) ois2.readObject();
        
        TreeMap<Integer,Integer>map1 = new TreeMap<>();
        for(int x : a) 
            if(check(x)) map1.put(x,map1.getOrDefault(x,0) + 1);
        
        TreeMap<Integer,Integer>map2 = new TreeMap<>();
        for(int x : b) 
           if(check(x)) map2.put(x,map2.getOrDefault(x,0) + 1);
        
        for(Map.Entry<Integer,Integer> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey()))
                System.out.println(entry.getKey() + " " + entry.getValue() + " " + map2.get(entry.getKey()));
        }
    }
}
