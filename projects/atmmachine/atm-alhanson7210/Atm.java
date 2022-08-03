/**
 * Atm starts a session, performs transactions, and ends a session when the user is completed
 * @author Alex Hanson
 * @version 1.0
 */
class Atm {
    //static variables
    private static int sessionNumber;
    //instance fields
    private BankUser currentUser = null;
    private int moneySupply;
    private ConsoleAtmUserInterface ui;

    //constructor

    /**
     * A constructor that assigns an atm with a moneySupply, created instance of a Console Atm User Interface, and initializes the session number
     * @param moneySupply is the starting amount of money the atm has
     */
    Atm(int moneySupply) {
        //
        this.moneySupply = moneySupply;
        this.ui = new ConsoleAtmUserInterface();
        sessionNumber = 0;
    }

    /**
     * Start session has welcome statement, gets their id and pin unless they quit, checks if they are in the bankUser array list, then assigns the user to the current user, increments the session number, displays the atm session and amount in the money supply, and welcomes the user
     * @return returns true unless they quit during the process.
     */
    //methods
    boolean startSession() {
        ui.displayMessage("\nWelcome to the USF atm machine!");
        String cardId = ui.readCard();
        if ("quit".equals(cardId)) {
            return false;
        }
        String cardPin = ui.readPin();

        BankUser user = BankUser.getUser(cardId,cardPin);
        while (user == null) {
            ui.displayError("The user does not exist or either your card's pin number or your card Id is incorrect");
            cardId = ui.readCard();
            if ("quit".equals(cardId)) {
                return false;
            }
            cardPin = ui.readPin();
            user = BankUser.getUser(cardId,cardPin);
        }
        this.currentUser = user;
        sessionNumber++;
        ui.displayMessage(String.format("Atm Session#%d [%d in the Atm]", Atm.sessionNumber, this.moneySupply));
        ui.displayMessage(String.format("\nWelcome %s!", currentUser.getName()));
        return true;
    }

    /**
     * changes the current user to null and exits the session
     */
    void endSession() {
        this.currentUser = null;
    }

    /**
     * perform transactions by using the user interface to choose a transaction type and do a withdrawal/check a balance/deposit money
     * @return a transaction type or null if finished with the card
     */
    TransactionType performTransaction() {
        //performing transactions
        TransactionType type = ui.chooseTransactionType();
        if (type == TransactionType.WITHDRAWAL){
            try {
                doWithdrawal();
            }
            catch (NullPointerException e) {
                ui.displayError("Withdrawal failed.");
            }
            return TransactionType.WITHDRAWAL;
        }
        else if (type == TransactionType.DEPOSIT) {
            try{
                doDeposit();
            }
            catch (NullPointerException e) {
                ui.displayError("Deposit failed.");
            }
            return TransactionType.DEPOSIT;
        }
        else if (type == TransactionType.CHECK_BALANCE) {
            try {
                doCheckBalance();
            }
            catch (NullPointerException e) {
                ui.displayError("Failed to check balance");
            }
            return TransactionType.CHECK_BALANCE;
        }
        else {
            ui.displayError("\nFinished with selected card.");
            return null;
        }
    }

    /**
     * reads a users accounts and takes a deposit envelope, credits that to an account, adds the deposit to the money supply in the atm, and displays the new balance of the account
     */
    private void doDeposit() {
        Account account = ui.readAccount(this.currentUser.getAccounts());
        if (account == null){
            return;
        }
        int deposit = ui.takeDepositEnvelope();
        account.credit(deposit);
        this.moneySupply += deposit;
        ui.displayMessage(String.format("\nBalance is %d.",account.getBalance()));
    }

    /**
     * reads an account and takes a withdrawal amount, debits it from the amount in the account as long as the atm as the money has enough to physicall give the user, subtracts the amount from the money supply and updates the user on the new balance
     */
    private void doWithdrawal() {
        Account account = ui.readAccount(this.currentUser.getAccounts());
        if (account == null){
            return;
        }
        int withdrawal = ui.readWithdrawalAmount();
        if (this.moneySupply - withdrawal < 0){
            ui.displayError(String.format("$%d could not be deducted: Atm doesn't have enough money.", withdrawal));
            return;
        }
        this.moneySupply -= withdrawal;
        account.debit(withdrawal);
        if (account.getBalance() - withdrawal >= 0){
            ui.deliverMoney(withdrawal);
        }
        ui.displayMessage(String.format("\nBalance is %d.",account.getBalance()));
    }

    /**
     * reads an account displays the current balance
     */
    private void doCheckBalance() {
        Account account = ui.readAccount(this.currentUser.getAccounts());
        if (account == null){
            return;
        }
        ui.displayMessage(String.format("\nYour balance is: $%d.", account.getBalance()));

    }

}
