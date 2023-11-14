class HouseMortgage extends Loan {
    public HouseMortgage(double loanAmount) {
        super(loanAmount);
    }

    @Override
    public double calculateInterest(double baseRate) {
        return super.calculateInterest(baseRate) + (super.calculateInterest(baseRate) * 0.01);
    }
}