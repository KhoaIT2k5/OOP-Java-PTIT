/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KHAI_BAO_LOP_VA_DOI_TUONG.BON_DIEM_TREN_MAT_PHANG_J04011;

import java.util.*;

class Point3D {
    private int x,y,z;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
    
    public static boolean check(Point3D a, Point3D b, Point3D c, Point3D d) {
        int ab_x = b.x - a.x, ab_y = b.y - a.y, ab_z = b.z - a.z;
        int ac_x = c.x - a.x, ac_y = c.y - a.y, ac_z = c.z - a.z;
        int ad_x = d.x - a.x, ad_y = d.y - d.y, ad_z = d.z - a.z;

        int n_x = ab_y * ac_z - ab_z * ac_y;
        int n_y = ab_z * ac_x - ab_x * ac_z;
        int n_z = ab_x * ac_y - ab_y * ac_x;

        int dotProduct = n_x * ad_x + n_y * ad_y + n_z * ad_z;

        return dotProduct == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());

            if(Point3D.check(p1,p2,p3,p4)){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
