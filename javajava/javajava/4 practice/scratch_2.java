import java.util.Scanner;
class Scratch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] months = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dom2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while (true) {
            System.out.print("Enter the month: ");
            if (scanner.hasNextInt()) {
                try {
                    int month = scanner.nextInt();
                    if (month != 2) {
                        System.out.println(months[month - 1]);
                        System.out.println(dom[month - 1]);
                    }else{
                        System.out.println("Enter year of this month: ");
                        int year = scanner.nextInt();
                        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                            System.out.println(months[month - 1]);
                            System.out.println(dom2[month - 1]);
                        }else{
                            System.out.println(months[month - 1]);
                            System.out.println(dom[month - 1]);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input");
                }
            } else {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }
}