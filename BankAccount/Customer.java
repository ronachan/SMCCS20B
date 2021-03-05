// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 1
import java.util.*;
import java.io.*;

public class Customer
{
  // declare variables
  String customername;
  ArrayList<Account> accounts = new ArrayList<Account>();

  public Customer(String name)
  {
    customername = name;
  }
  //Adds an account for a customer
  void open(Account acc)
  {
    accounts.add(acc);
  }
  //Removes an account for a customer
  void close(Account acc)
  {
    accounts.remove(acc);
  }
  // Main Method
  public static void main (String args[])
  {
    //Create a customer
    Customer c = new Customer("Rona Chan");
    // Create a checking account
    Account a = new CheckingAccount(50, 674290480);
    // Create a checking account plus
    Account b = new CheckingAccountPlus();

    // Open a checking account
    c.open(a);
    // Open a checking account plus
    c.open(b);

    //Add customer names to an arraylist
    ArrayList<Customer> names = new ArrayList<Customer>();
    names.add(c);
    System.out.println("Account Holder: " + names.get(0).customername);

    // Checking Account
    System.out.println("Initial balance of Checking Account: $" + a.balance());
    a.deposit(10000);
    System.out.println("Balance after deposit: $" + a.balance());
    System.out.println("Attempt to withdraw...");
    try
    {
      a.withdraw(11000);
    }
    catch(InsufficientFundsException ex)
    {
      System.out.println(ex.getMessage());
    }
    System.out.println("Checking Account current balance: $" + a.balance());

    //Remove Checking Account a
    c.close(a);

    // Checking Account Plus
    ((CheckingAccountPlus)b).setLimit(-9000);
    System.out.println("Initial balance of Checking Account Plus: $" + b.balance());
    b.deposit(10000);
    System.out.println("Balance after deposit: $" + b.balance());
    System.out.println("Attempt to withdraw...");
    try
    {
      b.withdraw(15000);
    }
    catch(InsufficientFundsException ex)
    {
      System.out.println(ex.getMessage());
    }
    System.out.println("Balance after withdrawl: $" + b.balance());
    b.deposit(500);
    System.out.println("Balance after deposit: $" + b.balance());
    b.deposit(18000);
    System.out.println("Checking Account Plus current balance: $" + b.balance());
    //Remove Checking Account Plus b
    c.close(b);
  }

}
