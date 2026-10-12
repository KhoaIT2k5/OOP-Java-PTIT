
package MANG_DOI_TUONG.J05010_SAP_XEP_DANH_SACH_MAT_HANG;

public class MatHang {
    private String ten,loai;
    private int ma;
    private double mua,ban;

    public MatHang(String ten, String loai, int ma, double mua, double ban) {
        this.ten = ten;
        this.loai = loai;
        this.ma = ma;
        this.mua = mua;
        this.ban = ban;
    }
    
    public double loiNhuan() {
        return this.ban - this.mua;
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.loai 
                + " " + String.format("%.2f",loiNhuan());
    }
}
