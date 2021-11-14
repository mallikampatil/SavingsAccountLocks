
import java.util.concurrent.locks.*;

public class DepositThread implements Runnable {
  SavingsAccount account; 
  int k; 
  DepositThread(SavingsAccount account, int k) {
    this.account = account; 
    this.k = k;
  }
  public void run() {
    try {
      account.deposit(k);
      Thread.sleep(1500);
    }
    catch (Exception e) {

    }
  }
}