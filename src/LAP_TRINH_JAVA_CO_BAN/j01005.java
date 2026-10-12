/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAP_TRINH_JAVA_CO_BAN;

/**
 *
 * @author ADMIN
 */
import java.util.*;
public class j01005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        if (!scanner.hasNextInt()) return;
        int T = scanner.nextInt(); // Số lượng bộ test
        while (T-- > 0) {
            int n = scanner.nextInt();
            double h = scanner.nextDouble();
            for (int i = 1; i < n; i++) {
                double distance = h * Math.sqrt((double) i / n);
                System.out.printf(Locale.US, "%.6f ", distance);
            }
            System.out.println();
        }
        scanner.close();
    }
}
