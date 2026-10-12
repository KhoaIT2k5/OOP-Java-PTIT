/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MANG_DOI_TUONG.J05042_BANG_XEP_HANG;
import java.util.*;
class SinhVien{
    private String ten;
    private int access,submit;

    public SinhVien(String ten, int access, int submit) {
        this.ten = ten;
        this.access = access;
        this.submit = submit;
    }

    public String getTen() {
        return ten;
    }

    public int getAccess() {
        return access;
    }

    public int getSubmit() {
        return submit;
    }
    
    @Override 
    public String toString() {
        return this.ten + " " + this.access + " " + this.submit;
    }
}
public class J05042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<SinhVien> list = new ArrayList<>();
        while(t-- > 0) {
            sc.nextLine();
            String ten = sc.nextLine();
            int access = sc.nextInt(), submit = sc.nextInt();
            list.add(new SinhVien(ten,access,submit));
        }
        Collections.sort(list, new Comparator<SinhVien>() {
            public int compare(SinhVien x, SinhVien y) {
                if(x.getAccess() != y.getAccess()) return y.getAccess() - x.getAccess();
                else {
                    if(x.getSubmit() != y.getSubmit()) return x.getSubmit()-y.getSubmit();
                    else return x.getTen().compareTo(y.getTen());
                }
            }
        });
        for(SinhVien x : list) System.out.println(x);
        sc.close();
    }
}
