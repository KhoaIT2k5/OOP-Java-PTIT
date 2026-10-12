
package MANG_DOI_TUONG.J05018_BANG_DIEM_HOC_SINH;
import java.util.*;
class HocSinh {
    private String ten, ma;
    private String diem;
    public static int stt = 1;
    public HocSinh(String ten, String diem) {
        this.ten = ten;
        this.ma = String.format("HS%02d",stt++);
        this.diem = diem;
    }

    public String getMa() {
        return ma;
    }
    
    public double trungBinh() {
        StringTokenizer st = new StringTokenizer(this.diem);
        double sum = 0;
        ArrayList<Double> score = new ArrayList<>();
        while(st.hasMoreTokens()) {
            double word = Double.parseDouble(st.nextToken());
            sum += word;
            score.add(word);
        }
        sum += score.get(0) + score.get(1);
        String tmp1 = String.format("%.2f", sum/12);
        double tmp2 = Double.parseDouble(tmp1);
        String tmp3 = String.format("%.1f", tmp2);
        return Double.parseDouble(tmp3);
    }
    public String loai() {
        double TB = trungBinh();
        if(TB >= 9) return "XUAT SAC";
        if(TB >= 8 && TB <= 8.9) return "GIOI";
        if(TB >= 7 && TB <= 7.9) return "KHA";
        if(TB >= 5 && TB <= 6.9) return "TB";
        return "YEU";
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + trungBinh() + " " + loai();
    }
}
public class J05018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<HocSinh> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            String ten = sc.nextLine();
            String diem = sc.nextLine();
            list.add(new HocSinh(ten, diem));
        }
        Collections.sort(list, (x,y) -> {
            if(y.trungBinh() != x.trungBinh()) 
                return Double.compare(y.trungBinh(),x.trungBinh());
            else return x.getMa().compareTo(y.getMa());
        });
        for(HocSinh x : list) System.out.println(x);
        sc.close();
    }
}

