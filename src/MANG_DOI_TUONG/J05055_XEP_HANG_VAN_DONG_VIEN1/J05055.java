package MANG_DOI_TUONG.J05055_XEP_HANG_VAN_DONG_VIEN1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Runner {
    private String ma, ten, ns;
    private int tuoi;
    private Date start, end;
    private static int stt = 1;
    public SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    public Runner(String ten, String ns, String start, String end) throws ParseException {
        this.ma = String.format("VDV%02d",stt++);
        this.ten = ten;
        this.tuoi = 2021 - Integer.parseInt(ns.substring(ns.length()-4));
        this.ns = ns;
        this.start = sdf.parse(start);
        this.end = sdf.parse(end);
    }
    public String getMa() {
        return ma;
    }
    public long uuTien() {
        if (this.tuoi < 18) return 0;
        if (this.tuoi >= 18 && this.tuoi < 25) return 1000;
        if (this.tuoi >= 25 && this.tuoi <= 32) return 2000;
        return 3000;
    }
    public long thanhTichThuc() {
        return this.end.getTime() - this.start.getTime();

    }
    public long thanhTichXepHang() {
        return thanhTichThuc()- uuTien();
    }
    public String formatTime(long time) {
        long timeToSeconds = time/1000;
        int hh = ((int)timeToSeconds/60)/60;
        int mm = ((int)timeToSeconds - hh*60*60)/60;
        int ss = (int)timeToSeconds % 60;
        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " "
                + formatTime(thanhTichThuc()) + " "
                + formatTime(uuTien()) + " "
                + formatTime(thanhTichXepHang());
    }
}
public class J05055 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Runner> list = new ArrayList<>();
        ArrayList<Runner> list2 = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            sc.nextLine();
            String ten = sc.nextLine(), ns = sc.next(),
                    start = sc.next(), end = sc.next();
            Runner runner = new Runner(ten,ns,start,end);
            list.add(runner);
            list2.add(runner); // Lưu vào list2 để in ra theo thứ tự VDV ban đầu
        }
        Collections.sort(list,(x,y) -> {
            return Long.compare(x.thanhTichXepHang(),y.thanhTichXepHang());
        });
        LinkedHashMap<Runner,Integer> rank = new LinkedHashMap<>();
        int hang = 1;
        rank.put(list.get(0), 1); // Cho người đầu tiên là hạng 1 sau khi sort
        for(int i=1 ; i<n ; i++) { // Xử lý Runner cùng thành tích thì xếp cùng hạng
            if (list.get(i).thanhTichXepHang() == list.get(i - 1).thanhTichXepHang())
                rank.put(list.get(i), hang);
            else {
                hang = i+1;
                rank.put(list.get(i), hang);
            }
        }
        for(Runner x : list2) System.out.println(x + " " + rank.get(x));
    sc.close();
    }
}
