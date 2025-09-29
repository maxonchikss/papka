package Practice5Generic;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 5 строк:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Строка " + (i + 1) + ": ");
            String line = scanner.nextLine();
            stack.push(line);
        }
        System.out.println("\nСтроки в обратном порядке:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}