package KETHUA;

import java.util.*;
abstract class shape {
    protected String color;
    protected Boolean filled;
    shape(String color, Boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Boolean isFilled() { return filled; }
    public void setFilled(Boolean filled) { this.filled = filled; }

    public abstract double getArea ();
    public abstract double getPerimeter();
    
    @Override
    public String toString() {
        return "\nColor : " + color + "\n" + "Filled : " + filled;
    }

    public String toString1() {
        return "\nColor : " + color + "\n" +"Filled : " + filled ;
    }
}
class Circle extends shape {
    private double radius;
    public Circle(double radius, String color, Boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return radius * radius * 3.14;
    }
    @Override
    public double getPerimeter() {         
        return radius * 2 * 3.14;
    }
    @Override 
    public String toString() {
        return "-----------------------" + 
                "\nRadius : " + String.format("%.2f",radius) + 
                super.toString() + "\n" +
                "Perimeter : " + String.format("%.2f", getPerimeter()) +
                "\nArea : " + String.format("%.2f", getArea()) +  
                "\n-----------------------";
    }
}
class rectangle extends shape {
    protected double width, height;
    public rectangle(double height, double width, String color, Boolean filled) {
        super(color, filled);
        this.width = Math.min(width,height);
        this.height = Math.max(width,height);
    } 
    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public double getPerimeter() {
        return 2*width + 2*height;
    } 
    @Override
    public String toString() {
        return "-----------------------"+ 
                "\nWidth : " + String.format("%.2f",width) + 
                "\nLength : " + String.format("%.2f",height) +
                 super.toString() + "\n" +
                "Perimeter : " + String.format("%.2f", getPerimeter()) +
                "\nArea : " + String.format("%.2f\n", getArea())  +
                "-----------------------";
    }
}
class square extends rectangle {

    public square(double width, double height, String color, Boolean filled) {
        super(width, height, color, filled);
    }
     @Override
    public String toString() {
        return "-----------------------" + 
                "\nSide : " + String.format("%.2f", width) + 
                super.toString1() +
                "\nPerimeter : " + String.format("%.2f\n", getPerimeter()) +
                "Area : " + String.format("%.2f\n", getArea())  +
                "-----------------------";
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Circle> list1 = new ArrayList<>();
        ArrayList<rectangle> list2 = new ArrayList<>();
        ArrayList<square> list3 = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            char c = sc.next().charAt(0);
            if(c == 'S'){
                double side = sc.nextDouble();
                String color = sc.next();
                boolean filled = sc.nextBoolean();
                square s = new square(side,side,color,filled);
                list3.add(s);
            } else if(c =='R') {
                double height = sc.nextDouble(), width = sc.nextDouble();
                String color = sc.next();
                boolean filled = sc.nextBoolean();
                rectangle r = new rectangle(height, width,color,filled);
                list2.add(r);
            } else {
                double radius = sc.nextDouble();
                String color = sc.next();
                boolean filled = sc.nextBoolean();
                Circle r = new Circle(radius, color,filled);
                list1.add(r);
            }
        }
        System.out.println("Circle :");
        for(Circle x : list1) System.out.println(x);
        System.out.println("Rectangle :");
        for(rectangle x : list2) System.out.println(x);
        System.out.println("Square :");
        for(square x : list3) System.out.println(x);
        sc.close();
    }   
}
