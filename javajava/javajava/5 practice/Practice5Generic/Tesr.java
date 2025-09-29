package Practice5Generic;

public class Tesr {
    public static void main(String[] args) {
       MyStack<Integer> stack = new MyStack<>();
        System.out.println("Размер стека: " + stack.getSize());
        for (int i = 1; i <= 15; i++) {
            stack.push(i);
        }

        System.out.println("Размер стека: " + stack.getSize());
        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("deleted: " + stack.pop());
        System.out.println("Размер стека: " + stack.getSize());
        System.out.println("Верхний элемент: " + stack.peek());
    }
}

//
//
