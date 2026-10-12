package MANG_DOI_TUONG.J05069_CAU_LAC_BO_BONG_DA_1;

import java.util.*;
class CLB {
    private String ma;
    private String ten;
    private long giaVe;

    public CLB(String ma, String ten, long giaVe) {
        this.ma = ma;
        this.ten = ten;
        this.giaVe = giaVe;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public long getGiaVe() {
        return giaVe;
    }
}

class TranDau {
    private String maTran;
    private long soCDV;
    private CLB clb;

    public TranDau(String maTran, long soCDV, CLB clb) {
        this.maTran = maTran;
        this.soCDV = soCDV;
        this.clb = clb;
    }

    public long doanhThu() {
        return soCDV * clb.getGiaVe();
    }

    public String getTenCLB() {
        return clb.getTen();
    }

    @Override
    public String toString() {
        return maTran + " " + clb.getTen() + " " + doanhThu();
    }
}

public class J05069 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        HashMap<String, CLB> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            long giaVe = Long.parseLong(sc.nextLine());
            map.put(ma, new CLB(ma, ten, giaVe));
        }
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<TranDau> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String maTran = sc.next();
            long soCDV = sc.nextLong();
            String maCLB = maTran.substring(1, 3);
            CLB clb = map.get(maCLB);
            list.add(new TranDau(maTran, soCDV, clb));
        }
        Collections.sort(list, (x, y) -> {
            if (x.doanhThu() != y.doanhThu())
                return Long.compare(y.doanhThu(), x.doanhThu());
            return x.getTenCLB().compareTo(y.getTenCLB());
        });
        for (TranDau x : list) System.out.println(x);
    }
}