package Geometry_1;

public class Square extends GeometricObject implements Colorable{
    public double side;

    public Square() {
        this.side = 0.0;
    }
    public Square(double side) {
        this.side = side;
    }
    public void setSide(double side){this.side = side;}
    public double getSide(){return side;}
    public void howToColor(){
        System.out.println("Раскрасьте все четыре стороны");
    }

    public double getArea() {
        return 0;
    }
}
