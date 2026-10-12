package XAU_KY_TU;

import java.util.Scanner;

public class CHUAN_HOA_HO_TEN1_J03004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String[] name = sc.nextLine().trim().split("\\s+");
            StringBuilder sb = new StringBuilder();
            for(int i=0 ; i<name.length ; i++) {
                String res = Character.toUpperCase(name[i].charAt(0)) +  name[i].substring(1).toLowerCase();
                sb.append(res + " ");
            }
            System.out.println(sb.toString());
        }
    }
}
