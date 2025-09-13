package Geometry_1;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(String message) {
        super(message);
    }
    public IllegalTriangleException() {
        super("Стороны треугольника нарушают правило.");
    }

}
