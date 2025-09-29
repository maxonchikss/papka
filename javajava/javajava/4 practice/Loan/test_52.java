package Loan;
import java.util.Scanner;
public class test_52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("enter Interest rate");
            double rate = scanner.nextDouble();
            System.out.println("enter amount of loan");
            double amount = scanner.nextDouble();
            System.out.println("enter year");
            int year = scanner.nextInt();
            LoanClass Loan = new LoanClass(rate, amount, year);
            System.out.println(Loan.getMonthlyPayment());
            System.out.println(Loan.getTotalPayment());
        }
        catch (IllegalArgumentException e){
            System.out.print("Invalid input");
        }
    }
}





