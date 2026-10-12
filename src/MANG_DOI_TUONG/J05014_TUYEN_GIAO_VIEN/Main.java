package MANG_DOI_TUONG.J05014_TUYEN_GIAO_VIEN;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J05014> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            String ten = sc.nextLine();
            String ma = sc.nextLine();
            double tin = Double.parseDouble(sc.nextLine());
            double chuyenMon = Double.parseDouble(sc.nextLine());
            J05014 gv = new J05014(ten,ma,tin,chuyenMon);
            list.add(gv);
        }
        Collections.sort(list, new Comparator<J05014>() {
            @Override
            public int compare(J05014 o1, J05014 o2) {
                return Double.compare(o2.tongDiem(),o1.tongDiem());
            }
        });
        for(J05014 x : list) System.out.println(x);
        sc.close();
    }
}
