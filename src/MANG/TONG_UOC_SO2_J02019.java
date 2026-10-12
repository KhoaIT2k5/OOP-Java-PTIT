import java.util.Scanner;

public class TONG_UOC_SO2_J02019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] sumOfDivisors = new int[b + 1];
            for (int i = 1; i <= b / 2; i++) {
                for (int j = 2 * i; j <= b; j += i) sumOfDivisors[j] += i;
            }
            int cnt = 0;
            for (int i = a; i <= b; i++) {
                if (sumOfDivisors[i] > i) cnt++;
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}