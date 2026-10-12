package KIEMTRA;

import java.io.*;
import java.util.*;
public class Bai4 {
    public static boolean check(int n) {
        int tmp = n, m = 0, cnt = 0;
        while(n != 0) {
            m = m*10 + n%10;
            cnt++;
            n = n/10;
        }
        return cnt >= 3 && tmp == m;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DAYSO.DAT"));
        
        ArrayList<Integer> a = (ArrayList<Integer>) ois1.readObject();

        TreeMap<Integer,Integer>map1 = new TreeMap<>();
        for(int x : a) 
            if(check(x)) map1.put(x,map1.getOrDefault(x,0) + 1);
        for(Map.Entry<Integer,Integer> entry : map1.entrySet()) {
               System.out.println(entry.getKey());
        }
    }
}
