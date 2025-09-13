package Geometry_1;

public class Rectangle extends GeometricObject implements Comparable{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String name, String color, boolean filled, double width, double height) {
        super(name, color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {return width;}
    public double getHeight() {return height;}

    public void setWidth(double width) {this.width = width;}
    public void setHeight(double height) {this.height = height;}
    public double getArea() {return width * height;}
}