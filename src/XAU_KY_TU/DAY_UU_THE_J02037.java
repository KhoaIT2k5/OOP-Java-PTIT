package XAU_KY_TU;

import java.util.Scanner;

public class DAY_UU_THE_J02037 {
    public static boolean check(String s) {
        String[] arr = s.trim().split("\\s+");
        int le = 0, chan = 0;
        for(String x : arr) if((x.charAt(x.length()-1) - '0') % 2 == 1) le++; else chan++;
        if((le > chan && arr.length % 2 == 1) ||
                (chan > le && arr.length % 2 == 0)) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine();
            System.out.println(check(s) ? "YES" : "NO");
        }
    }
}
