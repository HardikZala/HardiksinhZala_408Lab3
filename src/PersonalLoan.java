class PersonalLoan extends Loan {
    public PersonalLoan(double loanAmount) {
        super(loanAmount);
    }

    @Override
    public double calculateInterest(double baseRate) {
        return super.calculateInterest(baseRate) + (super.calculateInterest(baseRate) * 0.04);
    }
}
