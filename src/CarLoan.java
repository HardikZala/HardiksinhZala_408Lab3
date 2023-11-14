class CarLoan extends Loan {
    public CarLoan(double loanAmount) {
        super(loanAmount);
    }

    @Override
    public double calculateInterest(double baseRate) {
        return super.calculateInterest(baseRate) + (super.calculateInterest(baseRate) * 0.03);
    }
}
