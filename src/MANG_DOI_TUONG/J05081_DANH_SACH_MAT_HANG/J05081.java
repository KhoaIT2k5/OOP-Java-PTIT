package MANG_DOI_TUONG.J05081_DANH_SACH_MAT_HANG;

import java.util.*;

class hang {
    public String ma, ten, dvi;
    public int mua, ban;
    public static int ID = 0;
    public hang() {}
    public hang(String ten, String dvi, int mua, int ban) {
        this.ma = "MH" + String.format("%03d",++ID);
        this.ten = ten;
        this.dvi = dvi;
        this.mua = mua;
        this.ban = ban;
    }
    public int loiNhuan() {
        return ban - mua;
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + dvi + " " + mua + " " + ban + " " + loiNhuan();
    }   
}
public class J05081 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<hang> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            String dvi = sc.nextLine();
            int mua = Integer.parseInt(sc.nextLine());
            int ban = Integer.parseInt(sc.nextLine());
            hang h = new hang(ten, dvi, mua, ban);
            list.add(h);
        }
        Collections.sort(list, new Comparator<hang>(){
            public int compare(hang a, hang b) {
                if(a.loiNhuan() != b.loiNhuan()) return b.loiNhuan() - a.loiNhuan();
                else return a.ma.compareTo(b.ma);
            }
        });
        for (hang h : list) System.out.println(h);
        sc.close();
    }
}