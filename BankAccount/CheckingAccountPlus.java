// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 1
import java.util.Scanner;
import java.io.*;

public class CheckingAccountPlus extends CheckingAccount
{
  // Declare variables
  int negativeFee;
  int limit;
  // Default Constructor
  public CheckingAccountPlus()
  {
    // initialize variables
    negativeFee = 0;
    limit = -10000;
  }
  // Allows the presetlimit of -10000 to be adjusted
  public void setLimit(int amount)
  {
    limit = amount;
  }
  // deposits are added to negative fees first, then once there are no
  // more negative fees, the remainder of the deposit is added to the
  // balance
  public void deposit(int amount)
  {
    if(negativeFee < 0)
    {
      negativeFee += amount;
      balance += amount;

      if(negativeFee > 0)
      {
        negativeFee = 0;
      }
    }
    else
    {
      balance += amount;
    }
  }
  // withdrawls can result in negative balances as long as the balance does
  // not exceed the limit. When it exceeds the limit, the InsufficientFundsException
  // is caught; it will display a message that informs the customer that he/she
  // does not have enough funds for this transaction.
  public int withdraw(int amount) throws InsufficientFundsException
  {
    if(balance < limit)
    {
      throw new InsufficientFundsException("Insufficient Funds");

    }

    if(((balance-amount)< 0) && ((balance-amount)>=limit))
    {
      negativeFee = -((amount * 2) / 10);
      balance = ((balance - amount)+(negativeFee));
      if(balance < limit)
      {
        throw new InsufficientFundsException("Insufficient Funds");
      }
    }
    return balance;
  }
}
