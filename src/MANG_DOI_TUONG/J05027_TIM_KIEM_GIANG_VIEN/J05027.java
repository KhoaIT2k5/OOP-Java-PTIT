package J05027_TIM_KIEM_GIANG_VIEN;
import java.util.*;

class GiangVien {
    private String ma, hoTen, boMon;
    public static int stt = 1;
    public GiangVien(String ten, String boMon) {
        this.ma = String.format("GV%02d",stt++);
        this.hoTen = ten;
        this.boMon = boMon;
    }
    public String maBoMon() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(this.boMon);
        while(st.hasMoreTokens()) {
            sb.append(st.nextToken().charAt(0));
        }
        return sb.toString().toUpperCase();
    }
    public String getHoTen() {
        return hoTen;
    }
    @Override
    public String toString() {
        return this.ma + " " + this.hoTen + " " + maBoMon();
    }
}
public class J05027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GiangVien> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            list.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        }
        int q = sc.nextInt();
        while(q-- > 0) {
            String word = sc.next();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + word +":");
            String wordLower = word.toLowerCase();
            for(GiangVien x : list) {
                String hoTenLower = x.getHoTen().toLowerCase();
                if(hoTenLower.contains(wordLower)) System.out.println(x);
            }
        }
        sc.close();
    }
}

