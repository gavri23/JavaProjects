public class ServiceChargeChecking extends CheckingAccount{
    private double monthlyCommision = 0;
    public ServiceChargeChecking(String numAccount, String name, String identityNum, double startCash) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash);
    }
    public ServiceChargeChecking(String numAccount, String name, String identityNum, double startCash,double commision) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash);
        monthlyCommision = commision;
    }

    public double getMonthlyCommision() {
        return monthlyCommision;
    }
    public void setMonthlyCommision(double monthlyCommision) {
        this.monthlyCommision = monthlyCommision;
    }
    @Override
    public void ManageAccount() throws IllegalBalance{
        if(monthlyCommision > this.getBalance())
            throw new IllegalBalance("Overdraft! the bank doesn't allow this, sorry");
        this.setBalance(this.getBalance()-this.monthlyCommision);
    }
    @Override
    public boolean equals(Object serviceCharge){
       if( serviceCharge instanceof ServiceChargeChecking){
           boolean flag = super.equals(serviceCharge);
           if(!flag)//it means that the flag is negative == !flag is true
               return false;
           if((((ServiceChargeChecking) serviceCharge).monthlyCommision) != this.monthlyCommision)
               return false;
       }
       else{
           return false;
       }
       return true;
    }
}
