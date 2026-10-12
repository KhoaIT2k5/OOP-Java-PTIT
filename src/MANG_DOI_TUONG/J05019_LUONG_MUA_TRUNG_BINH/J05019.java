package MANG_DOI_TUONG.J05019_LUONG_MUA_TRUNG_BINH;

import java.util.*;

class rain{
    private String ten,ma;
    private int luongMua,soPhut;

    public rain(int ma,String ten, int soPhut, int luongMua) {
        this.ma = "T" + String.format("%02d",ma);
        this.ten = ten;
        this.soPhut = soPhut;
        this.luongMua = luongMua;
    }
    public void themTime(int minutes) {this.soPhut += minutes;}
    public void themMua(int Rain) {this.luongMua += Rain;}
    public String getTen() { return this.ten; }
    @Override
    public String toString() {
        return String.format("%s %s %.2f",this.ma,this.ten,((double)(this.luongMua*60)/this.soPhut));
    }
}
public class J05019 {
    public static int soPhut(String s1, String s2) {
        String[] start = s1.split(":");
        String[] end = s2.split(":");
        int time = Integer.parseInt(end[1]) + Integer.parseInt(end[0])*60 - (Integer.parseInt(start[1]) + Integer.parseInt(start[0])*60);
        return time;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<rain> list = new ArrayList<>();
        for(int i=0 ;i<n ; i++) {
            String name = sc.nextLine();
            String startTime = sc.nextLine();
            String endTime = sc.nextLine();
            int phut = soPhut(startTime,endTime);
            int luongMua = Integer.parseInt(sc.nextLine());
            int kt = 0;
            for(rain x : list) {
                if(x.getTen().equals(name)) {
                    x.themTime(phut);
                    x.themMua(luongMua);
                    kt = 1;
                }
            }
            if(kt == 0) list.add(new rain(i+1,name,phut,luongMua));
        }
        for (rain x : list) System.out.println(x);
        sc.close();
    }
}