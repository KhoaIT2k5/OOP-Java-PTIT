package XAU_KY_TU;

import java.math.*;
import java.util.*;

public class UOC_SO_CHUNG_LON_NHAT_CUA_SO_NGUYEN_LON_J03011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            BigInteger a=new BigInteger(sc.next());
            BigInteger b=new BigInteger(sc.next());
            System.out.println(a.gcd(b));
        }
        sc.close();
    }
}
