import java.util.Scanner;

/**
 * The user interface that does all the printing of messages, error messages, choosing transaction types, delivering money to the user, getting money, reading an account from an array of accounts from a user, reads a card id, reads the pin for that card, read withdrawal amounts, takes deposit envelopes, or returns a given card
 * @author Alex Hanson
 * @version 1.0
 */
class ConsoleAtmUserInterface {
    //static variables
    private static final String QUIT_STRING = "quit";
    //instance fields
    private Scanner inDevice;
    //constructor

    /**
     * A constructor that creates a new scanner
     */
    ConsoleAtmUserInterface() {
        inDevice = new Scanner(System.in);
    }
    //method

    /**
     * user chooses a transaction type from the enum Transactionn type
     * @return a transaction type or null if the user decides to return the card
     */
    TransactionType chooseTransactionType() {
        displayMessage("\nChoose a transaction type ...\n1. WITHDRAW\n2. DEPOSIT\n3. CHECK BALANCE\n4. RETURN CARD\n: ");
        int type = readNumber();
        while (type > 4) {
            type = readNumber();
        }
        if (type == 1) {
            return TransactionType.WITHDRAWAL;
        }
        else if (type == 2) {
            return TransactionType.DEPOSIT;
        }
        else if (type == 3){
            return TransactionType.CHECK_BALANCE;
        }
        else if (type == 4){
            returnCard();
            return null;
        }
        return null;
    }

    /**
     * displaying a message of how much the user recieves from the atm from their account if applicable
     * @param amount money given to the user from the atm as physical money
     */
    void deliverMoney(int amount) {
        displayMessage(String.format("Please take $%d", amount));
    }

    /**
     * prints the error message to the user
     * @param errorMessage string error message to convey to a user
     */
    void displayError(String errorMessage){
        System.out.print(errorMessage);
    }

    /**
     * prints a message to the user
     * @param message a string message to convey to the user
     */
    void displayMessage(String message) {
        System.out.print(message);
    }

    /**
     * prints a statement to user to give an amount of money
     * @return a dollar amount to be processed
     */
    private int getAmount() {
        displayMessage("\nAmount to be processed: ");
        return readNumber();
    }

    /**
     * takes a list of accounts and cycles through them for the user to pick an they want to enact a transaction for
     * @param accounts is an array of accounts from the current user
     * @return an account picked to do a transaction for or null if the user cancels the process
     */
    Account readAccount(Account[] accounts) {
        if (accounts.length == 3) {
            int selectionNumber = 1;
            for (Account account : accounts) {
                displayMessage("\n" + selectionNumber + ". " + account.toString() + "\n");
                selectionNumber++;
            }
            displayMessage("\n" + selectionNumber + ". " + "CANCEL\n: ");
            
            int option = readNumber();
            while (option > 4) {
                option = readNumber();
            }
            if (option == 1) {
                return accounts[0];
            }
            else if (option == 2) {
                return accounts[1];
            }
            else if (option == 3) {
                return accounts[2];
            }
            else {
                this.displayError("Canceled account selection.");
                return null;
            }
        }
        else if (accounts.length == 2) {
            int selectionNumber = 1;
            for (Account account : accounts) {
                displayMessage("\n" + selectionNumber + ". " + account.toString() + "\n");
                selectionNumber++;
            }
            displayMessage("\n" + selectionNumber + ". " + "CANCEL\n: ");
            
            int option = readNumber();
            while (option > 3) {
                option = readNumber();
            }
            if (option == 1) {
                return accounts[0];
            }
            else if (option == 2) {
                return accounts[1];
            }
            else {
                this.displayError("Canceled account selection.");
                return null;
            }
        }
        else {
            int selectionNumber = 1;
            for (Account account : accounts) {
                displayMessage("\n" + selectionNumber + ". " + account.toString() + "\n");
                selectionNumber++;
            }
            displayMessage("\n" + selectionNumber + ". " + "CANCEL\n: ");
            
            int option = readNumber();
            while (option > 2) {
                option = readNumber();
            }
            if (option == 1) {
                return accounts[0];
            }
            else {
                this.displayError("Canceled account selection.");
                return null;
            }
        }

    }

    /**
     * displays a message to the user to enter a card id or the quit string
     * @return the id of the card or the quit string
     */
    String readCard() {
        displayMessage("\nPlease enter your card ID or 'quit' to exit: ");
        String str = readString();
        if (QUIT_STRING.equals(str)) {
            return QUIT_STRING;
        }
        return str;
    }

    /**
     * processes a number and validates that number before returning a correct number for an amount
     * @return validated number for selection or a dollar amount
     */
    private int readNumber() {
        int amount = 0;
        boolean isNotNumber = true;
        while (isNotNumber){
            while (!inDevice.hasNextInt()) {
                inDevice.next();
            }
            amount = inDevice.nextInt();
            if (amount >= 0) {
                isNotNumber = false;
            }
        }
        return amount;
    }

    /**
     * displays a message to the user to enter a pin and returns the pin
     * @return the pin the user enters
     */
    String readPin() {
        displayMessage("Please enter your pin here: ");
        return readString();
    }

    /**
     * reads input from the user
     * @return a string of user input
     */
    private String readString() {
        if (inDevice.hasNext()) {
            return inDevice.next();
        }
        return null;
    }

    /**
     * display a message of how much to withdrawal and gets the designated amount
     * @return the amount of money to withdrawal
     */
    int readWithdrawalAmount() {
        displayMessage("How much to withdrawal?");
        return getAmount();
    }

    /**
     * displays a message saying that the card has been returned
     */
    private void returnCard() {
        displayMessage("\nHere's your card back!");
    }

    /**
     * displays a message about how much money is in a deposit envelope and gets that amount
     * @return the validated amount from the user
     */
    int takeDepositEnvelope() {
        displayMessage("How much money is in the envelope? ");
        int amount = getAmount();
        while (amount < 0) {
            displayError("The amount should be more than zero.");
            amount = getAmount();
        }
        return amount;
    }

}
