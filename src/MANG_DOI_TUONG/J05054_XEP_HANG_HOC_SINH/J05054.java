
package MANG_DOI_TUONG.J05054_XEP_HANG_HOC_SINH;
import java.util.*;
class HocSinh {
    private String ten,ma;
    private double diem;
    private static int stt = 1;
    public HocSinh(String ten, double diem) {
        this.ma = String.format("HS%02d",stt++);
        this.ten = ten;
        this.diem = diem;
    }
    public double getDiem() {
        return diem;
    }    
    public String loai() {
        if(this.diem < 5.0) return "Yeu";
        if(this.diem < 7.0) return "Trung Binh";
        if(this.diem < 9.0) return "Kha";
        return "Gioi";
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.diem + " " + loai();
    }
}
public class J05054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<HocSinh> list = new ArrayList<>();
        ArrayList<HocSinh> list2 = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            sc.nextLine();
            HocSinh hs = new HocSinh(sc.nextLine(),sc.nextDouble());
            list.add(hs);
            list2.add(hs); // Lưu vào list2 để in ra theo thứ tự hs ban đầu
        }
        Collections.sort(list,(x,y) -> {
            return Double.compare(y.getDiem(),x.getDiem());
        });
        LinkedHashMap<HocSinh,Integer> rank = new LinkedHashMap<>();
        int hang = 1;
        rank.put(list.get(0),1);
        for(int i=1 ; i<n ; i++) { // Xử lý cùng thành tích thì xếp cùng hạng
             if(list.get(i).getDiem() == list.get(i-1).getDiem()) {
                  rank.put(list.get(i), hang);
             } else {
                 hang = i+1;
                 rank.put(list.get(i), hang);
             }
        }
        for(HocSinh x : list2) System.out.println(x + " " + rank.get(x));
        sc.close();
    }
}
