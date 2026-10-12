package MANG_DOI_TUONG.J05066_TIM_KIEM_NHAN_VIEN_THEO_TEN;

import java.util.*;

class NhanVien {
    private String ma, ten;

    public NhanVien(String ma, String ten) {
        this.ten = ten;
        String cv = ma.substring(0, 2);
        int sh = Integer.parseInt(ma.substring(4)); // Trích xuất số hiệu nhân viên
        if (cv.equals("GD") && sh > 1) this.ma = "NV" + ma.substring(2); // Hạ xuống NV nếu số hiệu > 1
        else if ((cv.equals("TP") || cv.equals("PP")) && sh > 3) {
            this.ma = "NV" + ma.substring(2); // Hạ xuống NV nếu số hiệu > 3
        } else this.ma = ma;
    }

    public String getTen() {
        return ten;
    }
    
    public void setMaChucVu() {
        String tmp = this.ma.substring(2);
        this.ma = "NV" + tmp;
    }
    
    public String maChucVu() {
        return this.ma.substring(0, 2);
    }
    
    public String bacLuong() {
        return this.ma.substring(2, 4);
    }
    
    public String soHieuNV() {
        return this.ma.substring(4);
    }
    
    @Override
    public String toString() {
        return this.ten + " " + maChucVu() + " " + soHieuNV() + " " + bacLuong();
    }
}

public class J05066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        int cntTP = 0, cntPP = 0, cntGD = 0;
        ArrayList<NhanVien> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine().trim();
            String[] arr = s.split("\\s+");
            String ma = arr[0];
            StringBuilder tenBuilder = new StringBuilder();
            for (int j = 1; j < arr.length; j++) {
                tenBuilder.append(arr[j]);
                if (j != arr.length - 1) tenBuilder.append(" ");
            }
            String ten = tenBuilder.toString();
            NhanVien nv = new NhanVien(ma, ten);
            if (nv.maChucVu().equals("TP")) {
                if (cntTP < 3) cntTP++;  else nv.setMaChucVu();                
            } else if (nv.maChucVu().equals("PP")) {
                if (cntPP < 3) cntPP++;  else nv.setMaChucVu();
            } else if (nv.maChucVu().equals("GD")) {
                if (cntGD < 1) cntGD++;  else nv.setMaChucVu();
            }
            list.add(nv);
        }
        Collections.sort(list, (x, y) -> {
           if (!y.bacLuong().equals(x.bacLuong())) return y.bacLuong().compareTo(x.bacLuong());
           return x.soHieuNV().compareTo(y.soHieuNV());
        });

        int q = Integer.parseInt(sc.nextLine().trim());
        while (q-- > 0) {
            String s = sc.nextLine().trim();
            for (NhanVien x : list) {
                if (x.getTen().toLowerCase().contains(s.toLowerCase())) System.out.println(x);
            }
            System.out.println();
        }
        sc.close();
    }
}