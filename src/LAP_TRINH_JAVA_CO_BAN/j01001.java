package LAP_TRINH_JAVA_CO_BAN;

import java.util.*;

public class j01001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        if (a <= 0 || b <= 0)
            System.out.println(0);
        else
            System.out.printf("%d %d", 2 * a + 2 * b, a * b);
        sc.close();
    }
}
