class Loan {
    protected double loanAmount;

    public Loan(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double calculateInterest(double baseRate) {
        return loanAmount * baseRate;
    }

    public double getTotalAmountOwed(double baseRate) {
        return loanAmount + calculateInterest(baseRate);
    }
}