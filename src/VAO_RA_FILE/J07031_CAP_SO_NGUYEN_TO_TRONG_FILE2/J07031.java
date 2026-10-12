package VAO_RA_FILE.J07031_CAP_SO_NGUYEN_TO_TRONG_FILE2;
import java.io.*;
import java.util.*;
public class J07031 {
    public static int[] p = new int[1000003];
    public static void sieve() {
        for(int i=0 ; i<=1000002 ; i++) p[i] = 1;
        p[0] = p[1] = 0;
        for(int i=2 ; i <=1000 ; i++) {
            if(p[i] == 1) 
                for(int j = i*i ; j<=1000000 ; j += i) p[j] = 0;
        }
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        sieve();
        
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> b = (ArrayList<Integer>) ois2.readObject();
        
        
        HashMap<Integer,Integer> map1 = new HashMap<>(); 
        HashMap<Integer,Integer> map2 = new HashMap<>(); 
        for(int x : a) if(p[x] == 1) map1.put(x,1);
        for(int x : b) if(p[x] == 1) map2.put(x,1);
       
        TreeMap<Integer,Integer> res = new TreeMap<>();
        for(int x : a) 
            if(p[x] == 1 && x < 1000000-x && map1.containsKey(1000000 - x) 
                && (!map2.containsKey(1000000 - x) && !map2.containsKey(x))
            ) res.put(x,1000000-x); 
        
        for(Map.Entry<Integer,Integer> entry : res.entrySet()) 
            System.out.println(entry.getKey() + " " + entry.getValue());
        ois1.close();
        ois2.close();
    }
}
