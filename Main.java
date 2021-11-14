import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)
  {
    SavingsAccount testAccount = new SavingsAccount(101, 100);
    testAccount.printBalance();

    int n = 10; 
    int k = 100;
    ArrayList<SavingsAccount> accounts = new ArrayList<SavingsAccount>();
    ArrayList<SavingsAccount> reserves = new ArrayList<SavingsAccount>();

    for (int i = 0; i < n; i++) {
      SavingsAccount account = new SavingsAccount(i, 0);
      SavingsAccount reserve = new SavingsAccount(i*2, 0);
      accounts.add(account);
      reserves.add(reserve);
    }

    for (SavingsAccount reserve: reserves){
      accounts.get(0).transfer(k, reserve);
    }


    for (SavingsAccount account: accounts) {
      DepositThread deposit = new DepositThread(account, 1000);
      deposit.run();
      account.printBalance();
    }
    
  }
}
