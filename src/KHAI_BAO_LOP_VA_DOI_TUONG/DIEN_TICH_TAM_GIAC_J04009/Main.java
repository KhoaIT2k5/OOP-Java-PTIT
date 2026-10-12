package KHAI_BAO_LOP_VA_DOI_TUONG.DIEN_TICH_TAM_GIAC_J04009;


import java.util.*;
class Point {
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    double distance(Point b) {
        return Math.sqrt((this.x - b.x)*(this.x - b.x) + (this.y - b.y)*(this.y - b.y));
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            Point a = new Point(sc.nextDouble(), sc.nextDouble());
            Point b = new Point(sc.nextDouble(), sc.nextDouble());
            Point c = new Point(sc.nextDouble(), sc.nextDouble());
            double ab = a.distance(b), ac = a.distance(c), bc = b.distance(c);
            if(!(ab + ac > bc && ab + bc > ac && ac + bc > ab)) System.out.println("INVALID");
            else {
                double p = (ab + bc + ac)/2;
                System.out.printf("%.2f\n",Math.sqrt(p*(p-ab)*(p-bc)*(p-ac)));
            }
        }
        sc.close();
    }
}
