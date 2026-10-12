package MANG_DOI_TUONG.J05007_SAP_XEP_DANH_SACH_DOI_TUONG_NHAN_VIEN;


public class NhanVien {
    private String ma,ten,gt,ns,dc,mst,hd;

    public NhanVien(String ma, String ten, String gt, String ns, String dc, String mst, String hd) {
        this.ma = ma;
        this.ten = ten;
        this.gt = gt;
        this.ns = ns;
        this.dc = dc;
        this.mst = mst;
        this.hd = hd;
    }
    
    public int getNamSinh() {
        return Integer.parseInt(this.ns.substring(6));
    }
    public int getNgaySinh() {
        return Integer.parseInt(this.ns.substring(0, 2));
    }
    public int getThangSinh() {
        return Integer.parseInt(this.ns.substring(3, 5));
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " "
                + this.gt + " " + this.ns + " "
                + this.dc + " " + this.mst + " "
                + this.hd;
    }
}
