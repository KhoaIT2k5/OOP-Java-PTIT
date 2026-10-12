
package MANG_DOI_TUONG.J05011;

import java.util.*;

public class J05011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<gamer> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            String ma = sc.nextLine(),
                    ten = sc.nextLine(),
                    start = sc.nextLine(),
                    end = sc.nextLine();
            gamer tmp = new gamer(ma,ten,start,end);
            list.add(tmp);
        }
        Collections.sort(list, (x,y) -> {
           return y.gioChoi() - x.gioChoi();
        });
        for(gamer x : list) System.out.println(x);
        sc.close();
    }
}
