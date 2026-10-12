package KHAI_BAO_LOP_VA_DOI_TUONG.KHAI_BAO_LOP_POINT_J04001;

import static java.lang.Math.sqrt;

public class Point {
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {}

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double distance(Point a) {
        return sqrt((a.getX()-getX())*(a.getX()-getX()) + (a.getY()-getY())*(a.getY()-getY()));
    }
}
