package Geometry_1;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
//-----------------------------------------------------------------------------------------------------------------------------------
            System.out.print("Введите сторону 1: ");
            double side1 = input.nextDouble();
            System.out.print("Введите сторону 2: ");
            double side2 = input.nextDouble();
            System.out.print("Введите сторону 3: ");
            double side3 = input.nextDouble();
            System.out.print("Введите цвет треугольника: ");
            String color = input.next();
            System.out.print("Закрашен ли треугольник (true/false): ");
            boolean filled = input.nextBoolean();
            Triangle Ira = new Triangle("Ira", color, filled, side1, side2, side3);
            System.out.println(Ira);
//-----------------------------------------------------------------------------------------------------------------------------------
//            Triangle Anna = new Triangle("Anna", "pink", false, 3, 4, 5);
//            Triangle Olga = new Triangle("Olga", "pink", false, 6, 8, 10);
//            GeometricObject biggest_Triangle = GeometricObject.max(Anna, Olga);
//            System.out.println("The biggest triangle is: "+ GeometricObject.max(Anna, Olga).getName());
//-----------------------------------------------------------------------------------------------------------------------------------
//            Circle circle1 = new Circle("Olesya", "red", true, 3.0);
//            Circle circle2 = new Circle("Tanya", "blue", false, 5.0);
//            GeometricObject biggest_Circle = GeometricObject.max(circle1, circle2);
//            System.out.println("The biggest circle is: " + biggest_Circle.getName());
//
//            Rectangle rect1 = new Rectangle("Egor", "green", true, 4.0, 6.0);
//            Rectangle rect2 = new Rectangle("Petya", "yellow", false, 5.0, 5.0);
//            GeometricObject biggestRect = GeometricObject.max(rect1, rect2);
//            System.out.println("The biggest rectangle is: " + biggestRect.getName());
//-----------------------------------------------------------------------------------------------------------------------------------
//            Circle circletest1 = new Circle(7.0);
//            circletest1.setName("Gosha");
//            Circle circletest2 = new Circle(10.0);
//            circletest2.setName("Why you fraer go to back?");
//
//            Rectangle recttest1 = new Rectangle(10.0, 16.0);
//            recttest1.setName("Vovchik");
//            Rectangle rect2test2 = new Rectangle(50.0, 10.0);
//            rect2test2.setName("Tema");
//
//            Circle biggerCircle = (circletest1.compareTo(circletest2) >= 0) ? circletest1 : circletest2;
//            System.out.println("Наибольший круг: " + biggerCircle.getName() + " с радиусом " + biggerCircle.getRadius());
//
//            // Наибольшая фигура между кругом и прямоугольником
//            GeometricObject biggerShape1 = (circletest2.compareTo(recttest1) >= 0) ? circletest2 : recttest1;
//            System.out.println("Наибольшая фигура между кругом и прямоугольником: " + biggerShape1.getName());
//----------------------------------------------------------------------------------------------------------------------------------

        } catch (IllegalTriangleException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}