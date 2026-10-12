package XAU_KY_TU;

import java.util.Scanner;

public class XAU_DOI_XUNG_J03025 {
    public static boolean check(String s) {
        int left = 0, right = s.length()-1, cnt = 0;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) cnt++;
            left++; right--;
        }
        if(s.length() % 2 == 0 && cnt == 1) return true;
        if(s.length() % 2 == 1 && cnt <= 1) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String s = sc.next();
            if(check(s)) System.out.println("YES"); else System.out.println("NO");
        }
        sc.close();
    }
}
