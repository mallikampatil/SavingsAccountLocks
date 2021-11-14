import java.util.concurrent.locks.*;

public class WithdrawThread implements Runnable {
  SavingsAccount account; 
  int k; 
  WithdrawThread(SavingsAccount account, int k) {
    this.account = account; 
    this.k = k;
  }
  public void run() {
    try {
      account.withdraw(k);
      Thread.sleep(1500);
    }
    catch (Exception e) {

    }
  }
}