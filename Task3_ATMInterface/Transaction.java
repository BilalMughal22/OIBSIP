package Task3_ATMInterface;
public class Transaction {
    
    private String type;   // type of transaction (Deposit/Withdraw/Transfer)
    private double amount; // amount of transaction

    // Constructor
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Getters
    public String getType() { return type; }
    public double getAmount() { return amount; }

    // Display transaction as string
    @Override
    public String toString() {
        return type + " : Rs. " + amount;
    }
}