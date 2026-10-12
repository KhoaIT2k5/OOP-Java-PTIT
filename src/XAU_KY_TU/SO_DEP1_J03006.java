package XAU_KY_TU;

import java.util.Scanner;

public class SO_DEP1_J03006 {
    public static boolean check(String number) {
        int left = 0, right = number.length()-1;
        while(left <= right) {
            if((number.charAt(left)-'0') %2 == 1 || (number.charAt(right)-'0') %2 == 1) return false;
            if(number.charAt(left) != number.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test --> 0) {
            String number = sc.next();
            if(check(number)) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}
