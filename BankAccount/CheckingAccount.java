// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 1
import java.util.*;
import java.io.*;

public class CheckingAccount implements Account
{
  // Declare variables
  int balance;
  int accNum;
  // Default Constructor
  public CheckingAccount()
  {
    // Initialize variables
    accNum = 0;
    balance = 0;
  }
  // Constructor
  public CheckingAccount(int initialAmount, int accountNumber)
  {
    balance = initialAmount;
    accNum = accountNumber;
  }

  // returns the account number
  public int getAccountNumber()
  {
    return accNum;
  }
  // adds amount to balance
  public void deposit(int amount)
  {
    // won't allow the deposit of zero or a negative
    if(amount <= 0)
    {
      System.out.println("Error: cannot deposit a negative amount.");
    }
    else
    {
      balance += amount;
    }
  }
  // withdraws the current amount from the account
  public int withdraw(int amount) throws InsufficientFundsException
  {
    if (amount > balance)
    {
      throw new InsufficientFundsException("Insufficient Funds");
    }
    else
    {
      balance -= amount;
    }
    return balance;
  }
  // returns the balance
  public int balance()
  {
    return balance;
  }
  //
  public void transfer(Account to, int amount) throws InsufficientFundsException
  {
    if(balance < amount)
    {
      throw new InsufficientFundsException("Insufficient Funds");
    }
    if(amount <= 0)
    {
      System.out.println("Error: cannot deposit a negative amount");
    }
    else
    {
      // subtracts amount from current account
      balance -= amount;
      // deposits the amount into the account desired
      to.deposit(amount);
    }
  }
}
