package XAU_KY_TU;

import java.util.Scanner;
import java.util.StringTokenizer;

public class DAO_TU_J03032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            StringBuilder sb = new StringBuilder();
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                StringBuilder temp = new StringBuilder(word);
                sb.append(temp.reverse()).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
