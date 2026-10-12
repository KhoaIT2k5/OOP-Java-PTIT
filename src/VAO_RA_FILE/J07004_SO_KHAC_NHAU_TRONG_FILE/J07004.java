package VAO_RA_FILE.J07004_SO_KHAC_NHAU_TRONG_FILE;
import java.io.*;
import java.util.*;
public class J07004 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        while(sc.hasNextInt()) {
            int b = sc.nextInt();
            mp.put(b, mp.getOrDefault(b, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}