package XAU_KY_TU;

import java.util.Scanner;

public class CHUAN_HOA_HO_TEN2_J03005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String[] name = sc.nextLine().trim().split("\\s+");
            StringBuilder sb = new StringBuilder();
            for(int i=1 ; i< name.length ; i++) {
                String res = name[i].substring(0,1).toUpperCase() + name[i].substring(1).toLowerCase();
                if(i != name.length-1) sb.append(res + " ");
                else sb.append(res + ", ");
            }
            sb.append(name[0].toUpperCase());
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
