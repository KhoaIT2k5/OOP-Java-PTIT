package MANG;
    import java.util.*;
    public class MA_TRAN_NHI_PHAN_J02106 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), res = 0;
            int [][] a = new int[n][3];
            for(int i=0 ; i<n ; i++) {
                int cnt = 0;
                for(int j=0 ; j<3 ; j++) {
                    a[i][j] = sc.nextInt();
                    if(a[i][j] == 1 ) cnt++;
                }
                if(cnt > 3-cnt) res++;
            }
            System.out.println(res);
            sc.close();
        }
    }
