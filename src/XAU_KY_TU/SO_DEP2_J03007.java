package XAU_KY_TU;

import java.util.Scanner;

public class SO_DEP2_J03007 {

    public static boolean check(String number){
        if(number.charAt(0) != '8' || number.charAt(number.length()-1) != '8') return false;
        int sum = 0;
        for(int i=0 ; i<number.length() ; i++) sum = sum + number.charAt(i)-'0';
        if(sum % 10 != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String number = sc.next();
            if(check(number)) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }

}
