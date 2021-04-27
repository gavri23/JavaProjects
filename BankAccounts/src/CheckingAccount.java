public abstract class CheckingAccount extends BankAccount {
    public CheckingAccount(String numAccount, String name, String identityNum, double startCash) throws IllegalBalance {
        super(numAccount, name, identityNum, startCash);
    }
    public CheckingAccount(String numAccount, String name, String identityNum) {
        super(numAccount, name, identityNum);
    }


    public void writeCheck(double sumCheck) throws IllegalBalance{
        if(sumCheck > this.getBalance())
            throw new IllegalBalance("Overdraft! the bank doesn't allow this, sorry");
        this.setBalance(this.getBalance()-sumCheck);
    }

}
