package VAO_RA_FILE.J07015_SO_NGUYEN_TO_TRONG_FILE_NHI_PHAN;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class J07015 {
    public static boolean check(int n) {
        if(n < 2) return false;
        for(int i=2 ; i<=Math.sqrt(n) ; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) ois.readObject();
        ois.close();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int x : a) {
            if(check(x)) map.put(x,map.getOrDefault(x,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
