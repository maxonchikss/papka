package Loan;

public class LoanClass {
    private double InterestRate;
    private double Loan_Amount;
    private int NumberOfYears;

    public LoanClass(double InterestRate, double Loan_Amount, int numberOfYears){
    if (InterestRate <= 0 || numberOfYears <= 0 || Loan_Amount <= 0) {
        throw new IllegalArgumentException("Invalid Data");
    };
        this.InterestRate = InterestRate;
        this.Loan_Amount = Loan_Amount;
        this.NumberOfYears = numberOfYears;
    }

    public void setInterestRate(double InterestRate) {
        if (InterestRate <= 0){throw new IllegalArgumentException("Invalid Data");}
        this.InterestRate = InterestRate;}

    public void setLoan_Amount(double Loan_Amount) {
        if (Loan_Amount <= 0){throw new IllegalArgumentException("Invalid Data");}
        this.Loan_Amount = Loan_Amount;}

    public void setNumberOfYears(int numberOfYears) {
        if (NumberOfYears <= 0){throw new IllegalArgumentException("Invalid Data");}

            this.NumberOfYears = numberOfYears;
        }

    public double getInterestRate() {return InterestRate;}
    public double getLoan_Amount() {return Loan_Amount;}
    public int getNumberOfYears() {return NumberOfYears;}

    public double getMonthlyPayment() {
        double monthlyInterestRate = InterestRate / 1200;
        return Loan_Amount * monthlyInterestRate /
                (1 - 1 / Math.pow(1 + monthlyInterestRate, NumberOfYears * 12));
    }
    public double getTotalPayment() {
        return getMonthlyPayment() * NumberOfYears * 12;
    }


}
