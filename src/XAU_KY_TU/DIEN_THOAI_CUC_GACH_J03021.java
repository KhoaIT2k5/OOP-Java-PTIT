package XAU_KY_TU;
import java.util.Scanner;
public class DIEN_THOAI_CUC_GACH_J03021 {
    public static char get(char x){
        if (x<='C') return '2';
        if (x<='F') return '3';
        if (x<='I') return '4';
        if (x<='L') return '5';
        if (x<='O') return '6';
        if (x<='S') return '7';
        if (x<='V') return '8';
        return '9';
    }
    public static boolean res(String s){
        int left = 0, right = s.length()-1;
        while(left <= right) {
            if(get(s.charAt(left)) != get(s.charAt(right)) ) return false;
            left++; right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) System.out.println(res(sc.next().toUpperCase()) ? "YES" : "NO");
        sc.close();
    }
}