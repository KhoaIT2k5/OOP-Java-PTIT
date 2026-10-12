package MANG_DOI_TUONG.J05009_TIM_THU_KHOA_CUA_KY_THI;

import java.util.*;

public class J05009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); 
        double res = -1;
        ArrayList<ThiSinh> ts = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            int ma = i;
            String ten = sc.nextLine();
            String ns = sc.nextLine();
            double d1 = Double.parseDouble(sc.nextLine());
            double d2 = Double.parseDouble(sc.nextLine());
            double d3 = Double.parseDouble(sc.nextLine());
            ThiSinh tmp = new ThiSinh(ma,ten,ns,d1,d2,d3);
            res = Math.max(res, tmp.tongDiem());
            ts.add(tmp);
        }
        for(ThiSinh x : ts) if(res == x.tongDiem()) System.out.println(x);
        sc.close();
    }
}
