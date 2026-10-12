package VAO_RA_FILE.J07029_SO_NGUYEN_TO_LON_NHAT_TRONG_FILE.J07029;
import java.io.*;
import java.util.*;
public class J07029 {
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
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) ois.readObject();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int x : a) if(p[x] == 1) map.put(x,map.getOrDefault(x,0)+1);
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.reverse(list);
        for(int i=0 ; i<Math.min(10,list.size()) ; i++) 
            System.out.println(list.get(i) + " " + map.get(list.get(i)));
        ois.close();
    }
}
