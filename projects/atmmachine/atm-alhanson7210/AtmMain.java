import java.util.Objects;

/**
 * Atm Main creates an array of account for three atm users, creates a new atm, and loops through running a session, performing transactions during the user session, and printing bye once the sessions are completed
 * @author Alex Hanson
 * @version 1.0
 */
public class AtmMain {
    /**
     * the atm main uses while loops to service users during sessions, prints out user info(id and pin), and assigns an newly created instance of an atm with 20,000 dollars
     * @param args unused
     */
    public static void main(String[] args) {
        //accounts for bank users
        Account[] accounts1 = new Account[] {new Account("Checking","Tim's Checking Account", 200), new Account("Savings","Tim's Saving",1000)};
        Account[] accounts2 = new Account[] {new Account("Savings", "PrivateSavings", 12700), new Account("Checking", "USFChecking", 5432), new Account("Mortgage", "MyMortgage", 2345)};
        Account[] accounts3 = new Account[] {new Account("Savings", "USFSavings", 4230)};
        //creating atm bank users
        BankUser tim = new BankUser("Tim Bailey", "tb", "12", accounts1);
        BankUser bill = new BankUser("Bill Stewart", "bs", "13", accounts2);
        BankUser john = new BankUser("John McDaniels", "jm", "14", accounts3);
        //initializing atm
        Atm atmMachine = new Atm(20000);
        //beginning atm use

        System.out.print(String.format("The user %s was created.", tim.toString()));
        System.out.print(String.format("\nThe user %s was created.", bill.toString()));
        System.out.print(String.format("\nThe user %s was created.", john.toString()));

        //starting atm sessions
        boolean runSession = true;
        while (runSession) {
            //start session
            boolean userSession = atmMachine.startSession();
            if (!userSession) {
                atmMachine.endSession();
                runSession = false;
            }
            TransactionType type;
            while (userSession){
                //perform transactions

                type = atmMachine.performTransaction();
                if (Objects.equals(type, TransactionType.WITHDRAWAL)) {
                    System.out.println("\nFinished withdrawal.");
                }
                else if (Objects.equals(type, TransactionType.DEPOSIT)){
                    System.out.println("\nDeposit finished.");
                }
                else if (Objects.equals(type, TransactionType.CHECK_BALANCE)){
                    System.out.println("\nFinished account balance check.");
                }
                else {
                    userSession = false;
                }

            }

        }
        System.out.println("Bye!");
    }
}
