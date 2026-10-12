
package VAO_RA_FILE.J07005_SO_KHAC_NHAU_TRONG_FILE2;

import java.io.*;
import java.util.*;
public class J07005 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0 ; i<100000 ; i++) {
            int x = dis.readInt();
            map.put(x,map.getOrDefault(x,0)+1);
        }
        dis.close();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) 
            System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
