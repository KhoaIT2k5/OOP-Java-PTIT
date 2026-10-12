package VAO_RA_FILE.J07032_SO_THUAN_NGHICH_TRONG_FILE;

import java.io.*;
import java.util.*;

public class J07032 {
    public static boolean check(int n) {
        int tmp = n, m = 0, cnt = 0;
        while(n != 0) {
            if((n % 10) % 2 == 0) return false;
            cnt++;
            m = m*10 + n%10;
            n = n/10;
        }
        return cnt > 1 && cnt%2 == 1 && tmp == m;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        ArrayList<Integer> a = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> b = (ArrayList<Integer>) ois2.readObject();
        
        TreeMap<Integer,Integer> map1 = new TreeMap<>();
        TreeMap<Integer,Integer> map2 = new TreeMap<>();
        
        for(int x : a) if(check(x)) map1.put(x,map1.getOrDefault(x,0)+1);
        for(int x : b) if(check(x)) map2.put(x,map2.getOrDefault(x,0)+1);
        
        TreeMap<Integer,Integer> res = new TreeMap<>();        
        for(Map.Entry<Integer,Integer> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey()))
                res.put(entry.getKey(), entry.getValue() + map2.get(entry.getKey())); 
        }
        
        int cnt = 0;
        for(Map.Entry<Integer,Integer> entry : res.entrySet()) {
            cnt++;
            System.out.println(entry.getKey() + " " + entry.getValue());
            if(cnt == 10) break;
        }
        ois1.close();
        ois2.close();
    }
}
