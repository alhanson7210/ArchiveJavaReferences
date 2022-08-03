import java.util.ArrayList;

/**
 * This class defines a user at a Bank, tracking the user's id and pin that they use at an ATM machine and the accounts the user owns
 * @author Alex Hanson
 * @version 1.0
 */
public class BankUser {
  //static variables
  private static ArrayList<BankUser> bankUsers = new ArrayList<>();
    //Instance Variables
  private String name;
  private String id;
  private String pin;
  private Account[] accounts;
  //Constructor
  /**
   * Constructor for building a bank user
   * @param name - passed string of the
   * @param id -passed string of the user's username
   * @param pin -passed string of the user's pin
   * @param accounts -passed array of account objects
   */
  BankUser(String name, String id, String pin, Account[] accounts) {
	this.name = name;
	this.id = id;
	this.pin = pin;
	this.accounts = accounts;
	bankUsers.add(this);
  }
  //static methods
  /**
   *getUser takes in two String arguments to use an id and pin to checks if the BankUser class has a given user in its list of bank users
   * @param id possible username id
   * @param pin possible username pin
   * @return a user in the bank user's class array list or null if not found
   */
  static BankUser getUser(String id, String pin) {
      for (BankUser user : bankUsers) {
          if (id.equals(user.id) & pin.equals(user.pin)) {
              return user;
          }
      }
    return null;
  }
  //Methods
  /**
   * @return an array of the bank user's accounts
   */
  public Account[] getAccounts() {
	return this.accounts;
  }
  /**
   * @return user's name
   */
   public String getName() {
	 return this.name;
   }
   /**
	* @return a formatted String consisting of the bank user's full name, ID, and pin
	*/

  @Override
  public String toString() {
	return String.format("%s [%s: %s]", this.name, this.id, this.pin);
  }
  /**
   * Testing the bank user class with two users
   * @param args unused
   */
  public static void main(String[] args) {
	//first bank user
	System.out.println("___________________________________________________________________");
	//bank user's array of accounts
	Account[] bankUserOneArray = {new Account("Checking", "MyChecking", 90), new Account("Savings", "MySavings", 576)};
	//Instantiated BankUser
	BankUser dave = new BankUser("Dave Jobs", "davey", "4325", bankUserOneArray);
	Account[] davesAccounts = dave.getAccounts();
	//testing BankUser
	System.out.println("Bank User's Name: " + dave.getName());
	System.out.println("Bank User Information: " + dave.toString());
	//printing each bank user's account information
      for (Account davesAccount : davesAccounts) {
          System.out.println(davesAccount.toString() + "\n");
      }

	//second bank user
	System.out.println("___________________________________________________________________");
	//bank user's array of accounts
	Account[] bankUserTwoArray = {new Account("checking", "checkingAccount", 12), new Account("savings", "savingsAccount", 21), new Account("mortgage", "myMortgage", 321_000)};
	//Instantiated BankUser
	BankUser al = new BankUser("Al Mon", "ally", "a3g4", bankUserTwoArray);
	Account[] alsAccounts = al.getAccounts();

	System.out.println("Bank User's Name: " + al.getName());
	System.out.println("Bank User Information: " + al.toString());
	//printing each bank user's account information
      for (Account alsAccount : alsAccounts) {
          System.out.println(alsAccount.toString() + "\n");
      }
	System.out.println(BankUser.getUser("ally", "a3g4"));
	System.out.println(BankUser.getUser("davey", "4325"));
  }
}
