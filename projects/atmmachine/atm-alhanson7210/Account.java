/**
 * Creating a bank account
 * @author Alex Hanson
 * @version 1.0
 */
 public class Account {
   //static variables
   private static int idCount = 0;
   //instance variables
   private String type;
   private String name;
   private int balance;
   private String accountId;

   //Constructor
   /**
      @param type type of account
      @param name name of account
      @param amount current dollar amount in account
   */
   public Account(String type, String name, int amount) {
     this.type = type;
     this.name = name;
     this.balance = amount;
     idCount++;
     this.accountId = "account" + idCount;
   }
   /**
    * @return a formatted String consisting of the account details such as the name, type, and balance
    */
   @Override
   public String toString() {
     return String.format("%s [%s : %s]", this.name, this.type, this.accountId);
   }

   /**
      @return the current balance
   */
   int getBalance() {
     //balance
     return this.balance;
   }

   /**
      @param amount dollar amount deducted
      @return true or false based on if the amount would produce/yield a negative balnce
   */
   boolean debit(int amount) {
     if (balance - amount < 0) {
       System.out.println("$" + amount + " could not be deducted: This amount would leave a negative balance.");
       return false;
     }
     //debit
     balance -= amount;
     System.out.println("$" + amount + " was deducted from " + this.name + ".");
     return true;
   }

   /**
      @param amount dollar amount added
   */
   void credit(int amount) {
     //credit
     balance += amount;
     System.out.println("$" + amount + " was credited to " + this.name + ".");
   }

   /**
    *The Account creates two accounts and then calls each of the methods credit, debit, getBalance - printing out the Account information and the results after each step.
    * @param args unused
    */
   static void main(String[] args) {
     //constructing the account for a person named Dave
     Account davesAccount = new Account("Checking", "Dave's Checking Account", 2000);
     System.out.println(davesAccount.toString());
     //testing the credit
     davesAccount.credit(631);
     System.out.println(davesAccount.name + " has a current balance of: $" + davesAccount.getBalance() + ".\n");
     //testing the debit
     davesAccount.debit(926);
     System.out.println(davesAccount.name + " has a current balance of: $" + davesAccount.getBalance() + ".\n");

     //spacer
     System.out.println("___________________________________________________________________");
     //spacer

     //constructing the account for a person named Allyn
     Account allynsAccount = new Account("Savings", "Allyn's Savings", 1472);
     System.out.println(allynsAccount.toString());
     //testing the credit
     allynsAccount.credit(386);
     System.out.println(allynsAccount.name + " has a current balance of: $" + allynsAccount.getBalance() + ".\n");
     //testing the debit
     System.out.println(allynsAccount.debit(2690));
     System.out.println(allynsAccount.name + " has a current balance of: $" + allynsAccount.getBalance() + ".\n");

     System.out.println(allynsAccount.debit(1857));
     System.out.println(allynsAccount.name + " has a current balance of: $" + allynsAccount.getBalance() + ".\n");
   }
 }
