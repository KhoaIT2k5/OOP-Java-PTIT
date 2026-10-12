package XAU_KY_TU;

import java.util.Scanner;

public class SO_UU_THE_J03024 {
    public static int check(String s) {
        int even = 0, odd = 0;
        for(int i=0 ; i<s.length() ; i++) {
            if(s.charAt(0) == '0') return -1;
            if(!Character.isDigit(s.charAt(i))) return -1;
            if((s.charAt(i)-'0') % 2 == 0) even++; else odd++;
        }
        if( (even > odd && s.length()%2 == 0) || (odd > even && s.length()%2 == 1) ) return 1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String s = sc.next();
            if(check(s) == 1) System.out.println("YES");
            else if(check(s) == 0) System.out.println("NO");
            else System.out.println("INVALID");
        }
        sc.close();
    }
}
