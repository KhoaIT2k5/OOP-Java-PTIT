package MANG_DOI_TUONG.J05014_TUYEN_GIAO_VIEN;

public class J05014 {
    private String ten, ma ,maGV;
    private double tin, chuyenMon;
    public static int stt = 1;
    public J05014(String ten, String ma, double tin, double chuyenMon) {
        this.maGV = String.format("GV%02d", stt++);
        this.ten = ten;
        this.ma = ma;
        this.tin = tin;
        this.chuyenMon = chuyenMon;
    }
    public String monHoc() {
        if(this.ma.contains("A")) return "TOAN";
        if(this.ma.contains("B")) return "LY";
        return "HOA";
    }
    public double uuTien() {
        if(this.ma.contains("1")) return 2.0;
        if(this.ma.contains("2")) return 1.5;
        if(this.ma.contains("3")) return 1.0;
        return 0.0;
    }
    public double tongDiem() {
        return this.tin * 2 + this.chuyenMon + uuTien();
    }
    public String ketQua() {
        if(tongDiem() >= 18) return "TRUNG TUYEN";
        return "LOAI";
    }

    @Override
    public String toString() {
        return this.maGV + " " + this.ten + " "
                + monHoc() + " " + tongDiem() + " "
                + ketQua();
    }
}
