//import java.util.Scanner;
//public class Yuan {
//    public static void main(String[] args) {
//        final double ROUBLES_PER_YUAN = 11.91;
//        int yuan;
//        double roubles;
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Enter yuan");
//        yuan = input.nextInt();
//
//        roubles = yuan * ROUBLES_PER_YUAN;
//        System.out.println("Yuan is " + roubles);
//    }
//}

import java.util.Scanner;
public class Yuan {
    public static void main(String[] args) {
        final double ROUBLES_PER_YUAN = 11.91;
        int yuan, digit;
        double roubles;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter yuan");
        yuan = input.nextInt();

        roubles = yuan * ROUBLES_PER_YUAN;

        digit = yuan % 10;
        if (digit == 1)
            System.out.println(yuan + " юань " + " = " + roubles + " rub");
        if (digit >= 2 && digit < 5)
            System.out.println(yuan + " юаня " + " = " + roubles + " rub");
        if (digit >= 5)
            System.out.println(yuan + " юаней " + " = " + roubles + " rub");

    }
}



















































































































































































