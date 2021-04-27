public class InterestChecking extends NoServiceChargeChecking{
    private double Interest = 0;//number of percentages
    public InterestChecking(String numAccount, String name, String identityNum, double startCash,double minimumBalance) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash,minimumBalance);
    }
    public InterestChecking(String numAccount, String name, String identityNum, double startCash,double minimumBalance,double interest) throws IllegalBalance {
        super(numAccount,name,identityNum,startCash,minimumBalance);
        this.Interest = interest;
    }
    public double getInterest() {
        return Interest;
    }
    public double calcIncome(){
        return this.getBalance()*((100+ Interest)/100);
    }
    public void setInterest(double interest) {
        this.Interest = interest;
    }
    @Override
    public void ManageAccount() {
        this.setBalance(calcIncome());
    }
}
