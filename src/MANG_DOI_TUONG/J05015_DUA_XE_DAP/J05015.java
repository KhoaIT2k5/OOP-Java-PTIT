package MANG_DOI_TUONG.J05015_DUA_XE_DAP;

import java.util.*;

public class J05015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<courer> list = new ArrayList<>();
        while(n-- > 0) {
            String ten = sc.nextLine(), donVi = sc.nextLine(), endTime = sc.nextLine();
            courer cour = new courer(ten,donVi,endTime);
            list.add(cour);
        }
        Collections.sort(list, (x,y) -> {
            return Double.compare(y.vanToc(), x.vanToc());
        });
        for(courer x : list) System.out.println(x);
        sc.close();
    }
}
