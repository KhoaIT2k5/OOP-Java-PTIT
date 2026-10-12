package VAO_RA_FILE.J07021_CHUAN_HOA_XAU_HO_TEN_TRONG_FILE;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class J07021 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        while(sc.hasNextLine()) {
            String s = sc.nextLine().toLowerCase();
            
            if (s.equals("end")) break;
            
            StringTokenizer st = new StringTokenizer(s);
            StringBuilder sb = new StringBuilder();
            
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                sb.append(word.substring(0,1).toUpperCase()).append(word.substring(1));
                if(st.hasMoreTokens()) sb.append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        sc.close();
    }
}
