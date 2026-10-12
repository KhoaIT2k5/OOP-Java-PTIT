package VAO_RA_FILE.J07016_SO_NGUYEN_TO_TRONG_HAI_FILE_NHI_PHAN;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class J07016 {
    public static boolean check(int n) {
        if(n < 2) return false;
        for(int i=2 ; i<=Math.sqrt(n) ; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        int b[] = new int[10003];
        int c[] = new int[10003];
        ArrayList<Integer> a1 = (ArrayList<Integer>) ois1.readObject();
        for(int x : a1) if(check(x))  b[x]++;
        ArrayList<Integer> a2 = (ArrayList<Integer>) ois2.readObject();
        for(int x : a2)  if(check(x)) c[x]++;
        for(int i = 2; i <= 10000; i++) 
            if(b[i] > 0 && c[i] > 0)
                System.out.println(i + " " + b[i] + " " + c[i]);
        ois1.close(); ois2.close();
    }
}
