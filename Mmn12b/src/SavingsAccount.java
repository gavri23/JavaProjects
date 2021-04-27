public class SavingsAccount extends BankAccount{
    private double interest = 0;
    public SavingsAccount(String numAccount, String name, String identityNum, double startCash) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash);
    }
    public SavingsAccount(String numAccount, String name, String identityNum, double startCash, double inter) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash);
        interest = inter;
    }
    public double getInterest() {
        return interest;
    }
    public void setInterest(double interest) {
        this.interest = interest;
    }
    @Override
    public void ManageAccount()  {
        this.setBalance(this.getBalance()*((100+this.getInterest())/100));

    }
}
