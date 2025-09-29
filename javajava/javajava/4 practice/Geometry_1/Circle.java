package Geometry_1;
//нет смысла писать отедльный класс Comparable Circle - отличия будут только в названии
public class Circle extends GeometricObject implements Comparable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(String name, String color, boolean filled, double radius) {
        super(name, color, filled);
        this.radius = radius;
    }

    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}
    public double getArea() {return Math.PI * radius * radius;}
}