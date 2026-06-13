package Task3_ATMInterface;
import java.util.*;
import java.io.*;

public class Bank {

    private HashMap<String, Account> accounts;
    private static final String ACCOUNTS_FILE = "accounts.txt";
    private static final String TRANSACTIONS_FILE = "transactions.txt";

    // Constructor - load accounts from file
    public Bank() {
        accounts = new HashMap<>();
        loadAccounts();
        loadTransactions();
    }

    // Load accounts from file
    private void loadAccounts() {
        File file = new File(ACCOUNTS_FILE);

        if (!file.exists()) {
            accounts.put("bilal", new Account("bilal", "1234", 50000));
            accounts.put("ali", new Account("ali", "5678", 30000));
            accounts.put("sara", new Account("sara", "9999", 75000));
            saveAccounts();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String userID = parts[0];
                    String pin = parts[1];
                    double balance = Double.parseDouble(parts[2]);
                    accounts.put(userID, new Account(userID, pin, balance));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }

    // Load transactions from file
    private void loadTransactions() {
        File file = new File(TRANSACTIONS_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String userID = parts[0];
                    String type = parts[1];
                    double amount = Double.parseDouble(parts[2]);

                    if (accounts.containsKey(userID)) {
                        accounts.get(userID).addTransaction(new Transaction(type, amount));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
    }

    // Saveing accounts to file
    public void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNTS_FILE))) {
            for (Account account : accounts.values()) {
                writer.write(account.getUserID() + "," +
                        account.getPin() + "," +
                        account.getBalance());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    // Saving transactions to file
    public void saveTransactions() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE))) {
            for (Account account : accounts.values()) {
                for (Transaction t : account.getTransactionHistory()) {
                    writer.write(account.getUserID() + "," +
                            t.getType() + "," +
                            t.getAmount());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving transactions: " + e.getMessage());
        }
    }

    // Find account by userID
    public Account getAccount(String userID) {
        return accounts.get(userID);
    }

    // Checking if account exists
    public boolean accountExists(String userID) {
        return accounts.containsKey(userID);
    }

    // Transfer amount between two accounts
    public boolean transfer(Account from, Account to, double amount) {
        if (from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
            from.addTransaction(new Transaction("Transfer Sent to " + to.getUserID(), amount));
            to.addTransaction(new Transaction("Transfer Received from " + from.getUserID(), amount));
            saveAccounts();
            saveTransactions();
            return true;
        }
        return false;
    }
}