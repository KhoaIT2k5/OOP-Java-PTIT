package KHAI_BAO_LOP_VA_DOI_TUONG.PHAN_SO_J04003;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo ps = new PhanSo(sc.nextLong(), sc.nextLong());
        System.out.println(ps.rutGon());
        sc.close();
    }
}
