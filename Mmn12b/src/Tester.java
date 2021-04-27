public class Tester {
    public static void main(String[] args) throws IllegalBalance {
        BankAccount[] accounts = new BankAccount[11];
        BankAccount a = new InterestChecking("5565", "Dan", "243356769", 60000,400);
        accounts[0] = a;
        BankAccount b = new SavingsAccount("2343", "Bob", "253293004", 8000);
        accounts[1] = b;
        BankAccount c = new HighInterestSavings("6447", "Alice", "638967386", 656500,3,300);
        accounts[2] = c;
        BankAccount d = new NoServiceChargeChecking("1576", "Guy", "235656780", 50000,300);
        accounts[3] = d;
        CheckingAccount e = new ServiceChargeChecking("4266", "John", "252353657", 900000,300);
        accounts[4] = e;
        BankAccount f = new SavingsAccount("6535", "Maya", "677456365", 45000);
        accounts[5] = f;
        ServiceChargeChecking g = new ServiceChargeChecking("6589", "Shay", "874386477",60800,2000);
        accounts[6] = g;
        BankAccount h = new InterestChecking("1234", "Gavriel", "635675900",1000000000,10000,3);
        accounts[7] = h;
        CheckingAccount i = new NoServiceChargeChecking("8683", "Ben", "782293530",20000);
        accounts[8] = i;
        SavingsAccount j = new SavingsAccount("8593", "Neta", "857334389",900000,6);
        accounts[9] = j;
        NoServiceChargeChecking k = new InterestChecking("4453", "David", "873745121",300040,2000);
        accounts[10] = k;
        for (BankAccount account : accounts) {
            if(account instanceof CheckingAccount)
                ((CheckingAccount) account).writeCheck(60);
            if(account instanceof NoServiceChargeChecking){
                ((NoServiceChargeChecking) account).setMinimumBalance(800);
                System.out.println(account.getOwner() + "'s minimum balance of his account is: " +  ((NoServiceChargeChecking) account).getMinimumBalance());
            }
            System.out.println(account.toString());
            account.ManageAccount();
            System.out.println(account.toString());

        }

    }
}