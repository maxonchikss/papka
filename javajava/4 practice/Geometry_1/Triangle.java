package Geometry_1;

public class Triangle extends GeometricObject implements Comparable{
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;
    private String name;

    public Triangle(){}
    public Triangle(String name, String color, boolean filled, double side1, double side2, double side3) throws IllegalTriangleException {
        super(name, color, filled);
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException();
        }
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public void setName(String name) {this.name = name;}

    public double getSide1() {return side1;}
    public double getSide2() {return side2;}
    public double getSide3() {return side3;}
    public double getArea(){
        double s = (side1+side2+side3) / 2.0;
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }
    public String getName() {return name;}
    public double getPerimetr(){
        final double Perimetr = side1+side2+side3;
        return Perimetr;
    }
    public String toString(){
        return "Area: " + getArea() + " Perimetr: " + getPerimetr() + " Color: " + getColor() + " Filled: " + isFilled();
    }

}
