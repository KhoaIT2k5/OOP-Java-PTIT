///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package MANG_DOI_TUONG.KT1772026;
//
//import java.util.*;
//
//class MonHoc {
//    private String id;
//    private String name;
//
//    public MonHoc(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//}
//class GiangVien {
//    private String id;
//    private String name;
//    private double numOfHours;
//
//    public GiangVien(String id, String name) {
//        this.id = id;
//        this.name = name;
//        numOfHours = 0;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void addHour(double hour) {
//        numOfHours += hour;
//    }
//
//    @Override
//    public String toString() {
//        return this.name + " " +  String.format("%.2f",numOfHours);
//    }
//}
//public class Bai1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        ArrayList<MonHoc> a = new ArrayList<>();
//        for(int i=0 ; i<n ; i++) {
//            a.add(new MonHoc(sc.next(),sc.nextLine().trim()));
//        }
//        int m = sc.nextInt();
//        ArrayList<GiangVien> b = new ArrayList<>();
//        for(int i=0 ; i<m ; i++) {
//            b.add(new GiangVien(sc.next(), sc.nextLine().trim()));
//        }
//        int k = sc.nextInt();
//        while(k-- > 0) {
//            String gvId = sc.next();
//            String mhId = sc.next();
//            double h = sc.nextDouble();
//            for(GiangVien x: b) {
//                if(x.getId().equals(gvId)) {
//                    x.addHour(h);
//                    break;
//                }
//            } 
//        }
//        for (GiangVien x : b) System.out.println(x);
//        sc.close();
//    }
//}
