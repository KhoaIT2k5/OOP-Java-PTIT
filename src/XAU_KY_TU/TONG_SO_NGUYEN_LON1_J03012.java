package XAU_KY_TU;
import java.util.*;
import java.math.*;
public class TONG_SO_NGUYEN_LON1_J03012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            BigInteger a = new BigInteger(sc.next());
            BigInteger b = new BigInteger(sc.next());
            System.out.println(a.add(b));
        }
        sc.close();
    }
}
