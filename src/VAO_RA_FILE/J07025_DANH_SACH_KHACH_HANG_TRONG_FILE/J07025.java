package VAO_RA_FILE.J07025_DANH_SACH_KHACH_HANG_TRONG_FILE;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class KhachHang implements Comparable<KhachHang> {
    private String ma, ten, gioiTinh, ngaySinh, diaChi;
    private static int cnt = 1;

    public KhachHang(String ten, String gioiTinh, String ngaySinh, String diaChi) {
        this.ma = String.format("KH%03d", cnt++);
        this.ten = chuanHoaTen(ten);
        this.gioiTinh = gioiTinh;
        this.ngaySinh = chuanHoaNgay(ngaySinh);
        this.diaChi = diaChi;
    }

    private String chuanHoaTen(String s) {
        String[] arr = s.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String x : arr) {
            sb.append(Character.toUpperCase(x.charAt(0)))
              .append(x.substring(1))
              .append(" ");
        }
        return sb.toString().trim();
    }

    private String chuanHoaNgay(String s) {
        String[] arr = s.trim().split("/");
        if (arr[0].length() == 1) arr[0] = "0" + arr[0];
        if (arr[1].length() == 1) arr[1] = "0" + arr[1];
        return arr[0] + "/" + arr[1] + "/" + arr[2];
    }

    @Override
    public int compareTo(KhachHang o) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d1 = LocalDate.parse(this.ngaySinh, f);
        LocalDate d2 = LocalDate.parse(o.ngaySinh, f);
        return d1.compareTo(d2); // già trước, trẻ sau
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gioiTinh + " " + diaChi + " " + ngaySinh;
    }
}

public class J07025 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> ds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();
            ds.add(new KhachHang(ten, gioiTinh, ngaySinh, diaChi));
        }

        Collections.sort(ds);

        for (KhachHang x : ds)
            System.out.println(x);
    }
}