//package KIEMTRA;
//import java.util.*;
//import java.io.*;
//class SinhVien {
//    private String ma,ten,lop,mail,sdt;
//
//    public SinhVien(String ma, String ten, String lop, String mail, String sdt) {
//        this.ma = ma;
//        this.ten = ten;
//        this.lop = lop;
//        this.mail = mail;
//        this.sdt = getSoDT(sdt);
//    }
//    private String getSoDT(String s) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("0").append(s);
//        return sb.toString();
//    }
//    public String getMa() {
//        return ma;
//    }
//
//    public String getLop() {
//        return lop;
//    }
//    @Override
//    public String toString() {
//        return this.ma + " " + this.ten + " " + this.lop + " " + this.mail + " " + this.sdt;
//    }
//}
//public class Bai2 {
//    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(new File("DANHSACH.in"));
//        ArrayList<SinhVien> list = new ArrayList<>();
//        while(sc.hasNextLine()) {
//            String ma = sc.nextLine(),ten = sc.nextLine(),
//                    lop = sc.nextLine(),mail = sc.nextLine(), sdt = sc.nextLine();
//            SinhVien sv = new SinhVien(ma,ten,lop,mail,sdt);
//            list.add(sv);
//        }
//        Collections.sort(list,(SinhVien x, SinhVien y) -> {
//            if(x.getLop().equals(y.getLop()))
//                return x.getMa().compareTo(y.getMa());
//            return x.getLop().compareTo(y.getLop());
//        });
//        for(SinhVien x : list) { System.out.println(x);}
//    }
//}
