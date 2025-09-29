package Practice5;
import java.util.ArrayList;

public class test{
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("c++");
        words.add("java");
        words.add("python");
        words.add("java");
        words.add("c++");
        words.add("python");
        System.out.println("Исходный список: " + words);
        ArrayList<String> uniqueWords = RemoveDuplicates.removeDuplicates(words);
        System.out.println("Без дубликатов: " + uniqueWords);
        System.out.println(RemoveDuplicates.LinearSearch(words, "python"));

        Circle[] circles = {
                new Circle(2.0),
                new Circle(7.7),
                new Circle(6.3),
                new Circle(5.2)
        };

        Circle maxCircle = Circle.findMax(circles);
        System.out.println("Наибольшая окружность имеет радиус: " + maxCircle);


        Circle[][] circleses = {
                { new Circle(22.0), new Circle(73.7) },
                { new Circle(63.0), new Circle(53.2) },
                { new Circle(88.0), new Circle(33.3) }
        };

        Circle maxCircle2 = Circle.findMax2D(circleses);
        System.out.println("Наибольшая окружность имеет радиус: " + maxCircle2);


    }
}

