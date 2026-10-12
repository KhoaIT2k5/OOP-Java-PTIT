package MANG;

import java.util.*;
public class TICH_VOI_MA_TRAN_CHUYEN_VI_J02103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test ; t++) {

            int n = sc.nextInt(), m = sc.nextInt();
            int[][] a = new int[n][m], b = new int[m][n], c = new int[n][n];
            // Tạo ma trận
            for(int i=0 ; i<n ; i++) for(int j=0 ; j<m ; j++) a[i][j] = sc.nextInt();
            // Tạo ma trận chuyển vị
            for(int i=0 ; i<m ; i++) for(int j=0 ; j<n ; j++) b[i][j] = a[j][i];

            System.out.println("Test " + (t+1) + ":");
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) {
                    c[i][j] = 0;
                    for(int k=0 ; k<m ; k++) c[i][j] += a[i][k] * b[k][j];
                }
            }
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) System.out.print(c[i][j] + " ");
                System.out.println();
            }
        }
        sc.close();
    }
}
