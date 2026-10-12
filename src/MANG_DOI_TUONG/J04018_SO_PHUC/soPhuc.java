package MANG_DOI_TUONG.J04018_SO_PHUC;
import java.util.*;

class sp{
    private int thuc,ao;
    public sp(int thuc, int ao) {
        this.thuc = thuc;
        this.ao = ao;
    }
    public void setThuc(int thuc) { this.thuc = thuc; }
    public void setAo(int ao) { this.ao = ao; }
    public int getThuc() { return thuc; }
    public int getAo() { return ao; }

    public static sp cong(sp x,sp y) {
        int thuc = y.getThuc() + x.getThuc();
        int ao = y.getAo() + x.getAo();
        return new sp(thuc, ao);
    }
    public static sp tich(sp x, sp y) {
        int thuc = x.getThuc() * y.getThuc() - x.getAo() * y.getAo();
        int ao = x.getThuc()*y.getAo() + x.getAo()*y.getThuc();
        return new sp(thuc, ao);
    }
    @Override
    public String toString() {
        if(ao < 0) return thuc + " - " + ao*-1 + "i";
        return thuc + " + " + ao + "i";
    }
}
public class soPhuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            sp a = new sp(sc.nextInt(), sc.nextInt());
            sp b = new sp(sc.nextInt(), sc.nextInt());
            
            sp c1 = a.cong(a,b);
            sp c2 = c1.tich(c1, a);
            
            sp d = c1.tich(c1, c1);
            System.out.println(c2 + ", " + d);
        }
        sc.close();
    }
}