package Task3_ATMInterface;
import java.util.ArrayList;

public class Account {
    
    private String userID;      // user's ID
    private String pin;         // user's PIN
    private double balance;     // account balance
    private ArrayList<Transaction> transactionHistory; // list of transactions

    // Constructor
    public Account(String userID, String pin, double balance) {
        this.userID = userID;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    // Getters
    public String getUserID() { return userID; }
    public String getPin() { return pin; }
    public double getBalance() { return balance; }
    public ArrayList<Transaction> getTransactionHistory() { return transactionHistory; }

    // Add transaction to history
    public void addTransaction(Transaction t) {
        transactionHistory.add(t);
    }

    // Update balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Validate PIN
    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }
}