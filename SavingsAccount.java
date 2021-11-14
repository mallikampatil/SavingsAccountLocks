import java.util.concurrent.locks.*;

public class SavingsAccount
{
  int id; 
  int balance; 
  Lock lock = new ReentrantLock(); 
  final Condition ordinary  = lock.newCondition(); 
  final Condition preffered = lock.newCondition(); 

  SavingsAccount(int id, int balance) {
    this.id = id; 
    this.balance = balance;
  }

  public void deposit(int k)
  {
    lock.lock();
    try
    {
      System.out.println("Deposit: " + k + " into " + id);
      balance = balance + k;
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        lock.unlock();
    }
  }

  public void depositPreffered(int k)
  {
    lock.lock();
    try
    {
      ordinary.await();
      System.out.println("Deposit: " + k + " into " + id);
      balance = balance + k; 
      preffered.signal();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        lock.unlock();
    }
  }

  public void withdraw(int k)
  {
    lock.lock();
    try
    {
      System.out.println("Withdraw: " + k + " from " + id);
      balance = balance - k;
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        lock.unlock();
    }
  }

  public void withdrawPreffered(int k)
  {
    lock.lock();
    try
    {
      ordinary.await();
      System.out.println("Withdraw: " + k + " from " + id);
      balance = balance - k; 
      preffered.signal();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        lock.unlock();
    }
  }

  public void printBalance() {
    System.out.println("ID: " + id + " Balance: " + balance);
  }

  // Note: Transfer Method changed slightly from textbook implementation for program implementation. Notable change in parameters.
  void transfer(int k, SavingsAccount reserve) { 
    lock.lock();
    try {
      reserve.withdraw(k);
      deposit(k); 
    } finally {
      lock.unlock();
    }
    System.out.println("Transfer from account " + reserve.id + " to account " + this.id + " of amount " + k);
  }

}