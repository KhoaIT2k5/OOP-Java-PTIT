
package MANG_DOI_TUONG.J05009_TIM_THU_KHOA_CUA_KY_THI;


public class ThiSinh {
    private int ma;
    private String ten,ns;
    private double d1,d2,d3;

    public ThiSinh(int ma, String ten, String ns, double d1, double d2, double d3) {
        this.ma = ma;
        this.ten = ten;
        this.ns = ns;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }
    
    
    public double tongDiem() {
        return this.d1 + this.d2 + this.d3;
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.ns + " " + tongDiem();
    }
}
