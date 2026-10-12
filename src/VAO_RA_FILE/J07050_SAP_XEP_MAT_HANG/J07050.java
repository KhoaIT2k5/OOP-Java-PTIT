package VAO_RA_FILE.J07050_SAP_XEP_MAT_HANG;

import java.io.*;
import java.util.*;

class Hang{
    private String ma,ten,nhom;
    private double mua,ban;
    private static int stt = 1;

    public Hang(String ten, String nhom, double mua, double ban) {
        this.ma = String.format("MH%02d",stt++);
        this.ten = ten;
        this.nhom = nhom;
        this.mua = mua;
        this.ban = ban;
    }
    
    public double loiNhuan() {
        return this.ban - this.mua;
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.nhom + " " + 
                String.format("%.2f",loiNhuan());
    }
}
public class J07050 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        //Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<Hang> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            list.add(new Hang(sc.nextLine(),sc.nextLine(),
            Double.parseDouble(sc.nextLine()),Double.parseDouble(sc.nextLine())));
        }
        Collections.sort(list, new Comparator<Hang>(){
            @Override
            public int compare(Hang x, Hang y) {
                return Double.compare(y.loiNhuan(),x.loiNhuan());
            }
        });
        for(Hang x : list) System.out.println(x);
        sc.close();
    }
}

