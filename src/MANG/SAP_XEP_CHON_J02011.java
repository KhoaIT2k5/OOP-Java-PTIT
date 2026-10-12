

    import java.util.Scanner;
    public class SAP_XEP_CHON_J02011 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(); int a[] = new int [n];
            for(int i=0 ; i<n ; i++) a[i] = sc.nextInt();
            for(int i=0 ; i<n-1 ; i++) {
                System.out.print("Buoc " + (i + 1) + ": ");
                int pos = i;
                for (int j = i + 1; j < n; j++) if (a[pos] > a[j]) pos = j;
                if(pos != i) {
                    int tmp = a[i];
                    a[i] = a[pos];
                    a[pos] = tmp;
                }
                for (int j = 0; j < n; ++j) System.out.print(a[j] + " ");
                System.out.println();
            }
            sc.close();
        }
    }
