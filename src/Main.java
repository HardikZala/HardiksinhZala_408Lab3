import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final double BASE_RATE = 0.02;
    private static final ArrayList<Loan> loans = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Select from the following options:");
            System.out.println("1. Disburse a Loan");
            System.out.println("2. Show the list of all loans");
            System.out.println("3. Show sum of all loans");
            System.out.println("4. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    disburseLoan();
                    break;
                case 2:
                    showAllLoans();
                    break;
                case 3:
                    showSumOfLoans();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }

    private static void disburseLoan() {
        System.out.println("Select the loan type:");
        System.out.println("1. House mortgage");
        System.out.println("2. Car loan");
        System.out.println("3. Personal loan");

        int loanType = scanner.nextInt();
        System.out.print("Enter the amount of the loan: ");
        double loanAmount = scanner.nextDouble();

        Loan loan = null;

        switch (loanType) {
            case 1:
                loan = new HouseMortgage(loanAmount);
                System.out.println("Starting a new House mortgage. Current interest rate: " + (BASE_RATE + 0.01) * 100 + "%");
                break;
            case 2:
                loan = new CarLoan(loanAmount);
                System.out.println("Starting a new Car loan. Current interest rate: " + (BASE_RATE + 0.03) * 100 + "%");
                break;
            case 3:
                loan = new PersonalLoan(loanAmount);
                System.out.println("Starting a new Personal loan. Current interest rate: " + (BASE_RATE + 0.04) * 100 + "%");
                break;
            default:
                System.out.println("Invalid loan type. Loan not disbursed.");
                return;
        }

        loans.add(loan);
        System.out.println("Loan disbursed.");
    }

    private static void showAllLoans() {
        System.out.println("List of all loans");
        System.out.printf("%-15s%-15s%-15s\n", "Type", "Amount", "Amount owed");

        for (Loan loan : loans) {
            String loanType = loan.getClass().getSimpleName();
            double amountOwed = loan.getTotalAmountOwed(BASE_RATE);

            System.out.printf("%-15s$%-14.2f$%-14.2f\n", loanType, loan.loanAmount, amountOwed);
        }
    }

    private static void showSumOfLoans() {
        double sumAmount = 0;
        double sumAmountOwed = 0;

        for (Loan loan : loans) {
            sumAmount += loan.loanAmount;
            sumAmountOwed += loan.getTotalAmountOwed(BASE_RATE);
        }

        System.out.println("Sum of all Loans");
        System.out.printf("%-15s%-15s\n", "Amount", "Amount owed");
        System.out.printf("$%-14.2f$%-14.2f\n", sumAmount, sumAmountOwed);
    }
}