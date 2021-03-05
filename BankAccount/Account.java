// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 1
import java.util.Scanner;
import java.io.*;

public interface Account{
  // returns the account number
  int getAccountNumber();
  // deposits amount to current balance
  void deposit(int amount);
  // withdraws the current amount from the account
  int withdraw(int amount) throws InsufficientFundsException;
  // returns the balance
  int balance();
  // transfers money from one account to another
  void transfer(Account to, int amount);

}
