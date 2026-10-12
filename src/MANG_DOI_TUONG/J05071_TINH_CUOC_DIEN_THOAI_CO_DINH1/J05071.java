package MANG_DOI_TUONG.J05071_TINH_CUOC_DIEN_THOAI_CO_DINH1;
import java.text.*;
import java.util.*;
class Tinh {
    private String maVung;
    private String ten;
    private int giaCuoc;
    public Tinh(String maVung, String ten, int giaCuoc) {
        this.maVung = maVung;
        this.ten = ten;
        this.giaCuoc = giaCuoc;
    } 
    public String getMaVung() {
        return maVung;
    }
    public void setMaVung(String maVung) {
        this.maVung = maVung;
    }
    public String getTen() {
        return ten;
    }
    public int getGiaCuoc() {
        return giaCuoc;
    }
}
class CuocGoi {
    private String thueBao;
    private Date start,end;
    private Tinh tinh;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    public CuocGoi(String thueBao, String start, String end, Tinh tinh) throws ParseException {
        this.thueBao = thueBao;
        this.start = sdf.parse(start);
        this.end = sdf.parse(end);
        this.tinh = tinh;
    }
    public long soPhut() {
        long time= this.end.getTime() - this.start.getTime();
        if(this.thueBao.charAt(0) == '0') return time/60000;
        return (long) Math.ceil(time/180000.0);
    }
    public String thanhPho() {
        if(this.thueBao.charAt(0) == '0') return this.tinh.getTen();
        return "Noi mang";
    }
    public long giaCuoc() {
        if(this.thueBao.charAt(0) == '0') {
            return this.tinh.getGiaCuoc()*soPhut();
        }
        return 800 * soPhut();
    }
    @Override
    public String toString() {
        return this.thueBao + " " + thanhPho() + " " + soPhut() + " " + giaCuoc();
    }
}
public class J05071 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Tinh> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            Tinh t = new Tinh(sc.nextLine(),sc.nextLine(),sc.nextInt());
            sc.nextLine();
            map.put(t.getMaVung(),t);
        }
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<CuocGoi> b = new ArrayList<>();
        for(int i=0 ; i<m ; i++) {
            String thueBao = sc.next(), start = sc.next(), end = sc.next();
            if(thueBao.charAt(0) == '0'){
                String maVung = thueBao.substring(1,3);
                b.add(new CuocGoi(thueBao,start,end,map.get(maVung)));
            } else b.add(new CuocGoi(thueBao,start,end, null));
        }
        for(CuocGoi x : b) System.out.println(x);
        sc.close();
    }
}
