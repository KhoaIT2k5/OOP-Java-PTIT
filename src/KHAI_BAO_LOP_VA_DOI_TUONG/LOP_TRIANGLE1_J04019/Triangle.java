/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KHAI_BAO_LOP_VA_DOI_TUONG.LOP_TRIANGLE1_J04019;

public class Triangle {
    private Point a,b,c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }
    
    public boolean valid() {
        double ab = a.distance(b), bc = b.distance(c), ac = c.distance(a);
        return ab + ac > bc && ab + bc > ac && ac + bc > ab;
    }
    
    public String getPerimeter() {
        double ab = a.distance(b), bc = b.distance(c), ac = c.distance(a);
        return String.format("%.3f", ab + bc + ac);
    }
}
