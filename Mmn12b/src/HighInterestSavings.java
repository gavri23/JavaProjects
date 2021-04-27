public class HighInterestSavings extends SavingsAccount{
    private double minimumBalance;
    public HighInterestSavings(String numAccount, String name, String identityNum, double startCash,double interest) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash,interest);
        minimumBalance = 0;
    }
    public HighInterestSavings(String numAccount, String name, String identityNum, double startCash, double interest, double minBal) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash,interest);
        minimumBalance = minBal;
    }
    public double getMinimumBalance() {
        return minimumBalance;
    }
    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

}
