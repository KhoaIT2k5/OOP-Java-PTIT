package KHAI_BAO_LOP_VA_DOI_TUONG.DANH_SACH_MON_THI_J07058;

import java.io.*;
import java.util.*;

class MonHoc implements Comparable<MonHoc> {
    private String id;
    private String name;
    private String form;
    public MonHoc(String id, String name, String form) {
        this.id = id;
        this.name = name;
        this.form = form;
    }
    @Override
    public int compareTo(MonHoc o) {
        return this.id.compareTo(o.id);
    }
    @Override
    public String toString() {
        return String.format("%s %s %s", this.id, this.name, this.form);
    }
}

public class J07058 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("MONHOC.in")).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            a.add(new MonHoc(sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        Collections.sort(a);
        for (MonHoc x : a) System.out.println(x);
    }
}