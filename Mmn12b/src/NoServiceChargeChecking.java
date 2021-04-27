public class NoServiceChargeChecking extends CheckingAccount{
    private double minimumBalance = 0;
    public NoServiceChargeChecking(String numAccount, String name, String identityNum, double startCash) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash);
    }
    public NoServiceChargeChecking(String numAccount, String name, String identityNum, double startCash,double minBalance) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash);
        if(minBalance < 0)
            throw new IllegalBalance("minimum balance must be positive");
        minimumBalance = minBalance;
    }
    @Override
    public void ManageAccount() {
    }
    public double getMinimumBalance() {
        return minimumBalance;
    }
    public void setMinimumBalance(double balance){
        minimumBalance = balance;
    }
    @Override
    public boolean equals(Object noServiceCharge){
        if( noServiceCharge instanceof NoServiceChargeChecking){
            boolean flag = super.equals(noServiceCharge);//calling the BankAccount equals method to check if its the same details of the account.
            if(!flag)//it means that the flag is negative == !flag is true
                return false;
            if((((NoServiceChargeChecking) noServiceCharge).minimumBalance) != this.minimumBalance)
                return false;
        }
        else{
            return false;
        }
        return true;
    }

}
