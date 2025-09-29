package decorator;

public class Main {
    public static void main(String[] args) {
        Text text = new PlainText("Welcome to Twin peaks!");

        Text boldText = new BoldDecorator(text);
        Text italicBold = new ItalicDecorator(boldText);
        Text decorated = new UnderlineDecorator(italicBold);
        Text anotherdecorated = new UnderlineDecorator(boldText);

        System.out.println(text.display());
        System.out.println(boldText.display());
        System.out.println(italicBold.display());
        System.out.println(decorated.display());
        System.out.println(anotherdecorated.display());
    }
}
