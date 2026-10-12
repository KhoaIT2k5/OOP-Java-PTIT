
package MANG_DOI_TUONG.J05012_TINH_TIEN;

public class MatHang {
    private String ma, ten;
    private long soLuongMua, donGia, chietKhau;

    public MatHang(String ma, String ten, long soLuongMua, long donGia, long chietKhau) {
        this.ma = ma;
        this.ten = ten;
        this.soLuongMua = soLuongMua;
        this.donGia = donGia;
        this.chietKhau = chietKhau;
    }
    
    public long tongTien() {
        return this.donGia * this.soLuongMua - this.chietKhau;
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.soLuongMua + " " 
                + this.donGia + " " + this.chietKhau + " " + tongTien();
    }
}
