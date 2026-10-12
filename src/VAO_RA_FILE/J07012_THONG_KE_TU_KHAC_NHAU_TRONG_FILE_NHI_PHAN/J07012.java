package VAO_RA_FILE.J07012_THONG_KE_TU_KHAC_NHAU_TRONG_FILE_NHI_PHAN;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class J07012 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) ois.readObject();
        HashMap<String, Integer> b = new HashMap<>();
        for (String x : a) {
            String[] tmp = x.toLowerCase().split("[^a-z0-9]+");
            for(String y : tmp)
                if (!y.isEmpty()) b.put(y, b.getOrDefault(y, 0) + 1);
        }
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(b.entrySet());
        Collections.sort(list,(Map.Entry<String, Integer> x,Map.Entry<String, Integer> y) -> {
           if(x.getValue().equals(y.getValue())) return x.getKey().compareTo(y.getKey());
           return Integer.compare(y.getValue(), x.getValue()); 
        });
        for(Map.Entry<String,Integer> x : list) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
        ois.close();
    }
}
