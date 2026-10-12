package VAO_RA_FILE.J07007_LIET_KE_TU_KHAC_NHAU;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class J07007 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        TreeSet<String> set = new TreeSet<>();
        while(sc.hasNext()) {
            String word = sc.next().toLowerCase();
            set.add(word);
        }
        for(String x : set) System.out.println(x);
        sc.close();
    }
}
