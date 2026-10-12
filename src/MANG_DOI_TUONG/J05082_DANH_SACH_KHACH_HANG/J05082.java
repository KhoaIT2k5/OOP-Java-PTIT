package MANG_DOI_TUONG.J05082_DANH_SACH_KHACH_HANG;
import java.util.*;
import java.text.*;

class KhachHang {
    private String ma, ten, gioiTinh, ngaySinh, diaChi;
    private static int stt = 1;

    public KhachHang(String ten, String gioiTinh, String ngaySinh, String diaChi) {
        this.ma = String.format("KH%03d", stt++);
        this.ten = chuanHoaTen(ten);
        this.gioiTinh = gioiTinh;
        this.ngaySinh = chuanHoaNgay(ngaySinh);
        this.diaChi = diaChi;
    }

    private String chuanHoaTen(String s) {
        String[] a = s.trim().toLowerCase().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (String x : a) {
            res.append(Character.toUpperCase(x.charAt(0)))
               .append(x.substring(1))
               .append(" ");
        }
        return res.toString().trim();
    }

    private String chuanHoaNgay(String s) {
        String[] a = s.split("/");
        String ngay = a[0];
        String thang = a[1];
        String nam = a[2];

        if (ngay.length() == 1) ngay = "0" + ngay;
        if (thang.length() == 1) thang = "0" + thang;

        return ngay + "/" + thang + "/" + nam;
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(ngaySinh);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gioiTinh + " " + diaChi + " " + ngaySinh;
    }
}

public class J05082 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();

            list.add(new KhachHang(ten, gioiTinh, ngaySinh, diaChi));
        }
        Collections.sort(list, (a, b) -> {
            try {
                return a.getDate().compareTo(b.getDate());
            } catch (ParseException e) {
                return 0;
            }
        });
        for (KhachHang x : list) System.out.println(x);
        sc.close();
    }
}