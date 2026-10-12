
package VAO_RA_FILE.J07022_LOAI_BO_SO_NGUYEN;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07022 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<String> set = new ArrayList<>();
        while(sc.hasNext()) {
            String s = sc.next();
            try {
              int n = Integer.parseInt(s);
            } catch(Exception e) { set.add(s); }
        }
        Collections.sort(set);
        for(String x : set) System.out.print(x + " "); 
        sc.close();
    }
}
