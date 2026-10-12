package XAU_KY_TU;

import java.util.Scanner;

public class SO_DEP3_J03008 {
    public static boolean check(String number){
        int left = 0, right = number.length()-1;
        while(left < right) {
            if(
                    number.charAt(left) != number.charAt(right) || ((number.charAt(left) != '2' && number.charAt(left) != '3'&& number.charAt(left) != '5' && number.charAt(left) != '7') ||
                    (number.charAt(right) != '2' && number.charAt(right) != '3'&& number.charAt(right) != '5' && number.charAt(right) != '7'))
            ) return false;
            left++; right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String number = sc.next();
            if(check(number)) System.out.println("YES"); else System.out.println("NO");
        }
        sc.close();
    }
}
