public abstract class BankAccount {
    private String numberAccount;
    private String owner;
    private String Id;
    private double balance;

    public BankAccount(String numAccount, String name, String identityNum, double startCash) throws IllegalBalance {
        if(startCash < 0 )
            throw new IllegalBalance("oh sorry, the bank doesn't allow negative balance");
        numberAccount = numAccount;
        owner = name;
        Id = identityNum;
        balance = startCash;
    }
    public BankAccount(String numAccount, String name, String identityNum) {
        numberAccount = numAccount;
        owner = name;
        Id = identityNum;
    }
    public double getBalance() {
        return balance;
    }
    public String getId() {
        return Id;
    }
    public String getNumberAccount() {
        return numberAccount;
    }
    public String getOwner() {
        return owner;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setId(String id) {
        this.Id = id;
    }
    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void InsertCash(double cash) {
        this.balance += cash;
    }
    public void WithdrawCash(double cash) throws IllegalBalance {
        if (cash > this.balance)
            throw new IllegalBalance("Overdraft! the bank doesn't allow this, sorry");
        this.balance -= cash;
    }
    public abstract void ManageAccount() throws IllegalBalance;
    public String toString() {
        String bankAccount = "";
        String balance = String.valueOf(this.balance);
        bankAccount = owner + "\n" + Id + "\n" + numberAccount + "\n" + balance +"\n";
        return bankAccount;
    }
    public boolean equals(Object account) {
        if (account instanceof BankAccount) {
            if((((BankAccount) account).balance)!= this.balance)
                return false;
            if(!((BankAccount) account).numberAccount.equals(this.numberAccount))
                return false;
            if(!((BankAccount) account).owner.equals(this.owner))
                return false;
            if(!((BankAccount) account).Id.equals(this.Id))
                return false;
        }
        else {
            System.out.println("Error: This object is not a bank account");
        }
        return true;
    }
}
