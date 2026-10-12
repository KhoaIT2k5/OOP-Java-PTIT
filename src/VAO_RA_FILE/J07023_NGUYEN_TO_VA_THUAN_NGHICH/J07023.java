package VAO_RA_FILE.J07023_NGUYEN_TO_VA_THUAN_NGHICH;

import java.io.*;
import java.util.*;

public class J07023 {
    public static int[] p = new int[10005]; 
    public static void sieve() {
        for (int i = 0; i <= 10000; i++) p[i] = 1;
        p[0] = p[1] = 0;
        for (int i = 2; i <= 100; i++) {
            if (p[i] == 1) {
                for (int j = i * i; j <= 10000; j += i) p[j] = 0;
            }
        }
    }
    
    public static boolean thuanNghich(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i < s.length() / 2; ++i)
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        int[] a = new int[10005];
        int[] b = new int[10005];
        
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();     
        
        for (int x : list1) {
            if (x >= 2 && x <= 10000 && p[x] == 1 && thuanNghich(x)) {
                a[x]++;
            }
        }
            
        for (int x : list2) {
            if (x >= 2 && x <= 10000 && p[x] == 1 && thuanNghich(x)) {
                b[x]++;
            }
        }

        for (int i = 2; i <= 10000; i++) {
            if (a[i] > 0 && b[i] > 0) {
                System.out.println(i + " " + a[i] + " " + b[i]);
            }
        }        
        ois1.close(); 
        ois2.close();
    }
}

