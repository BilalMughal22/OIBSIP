package Task3_ATMInterface;
import java.util.Scanner;

public class ATMOperations {

    private Account account; // current logged in account
    private Bank bank;       // reference to bank
    private Scanner scanner; // for user input

    // Constructor
    public ATMOperations(Account account, Bank bank) {
        this.account = account;
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    // Shows transaction history
    public void showTransactionHistory() {
        System.out.println("\n===== Transaction History =====");
        if (account.getTransactionHistory().isEmpty()) {
            System.out.println("No transactions yet!");
        } else {
            for (Transaction t : account.getTransactionHistory()) {
                System.out.println(t);
            }
        }
        System.out.println("===============================");
    }

    // Withdraw money
    public void withdraw() {
        System.out.println("\n===== Withdraw =====");
        System.out.print("Enter amount to withdraw: Rs. ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance!");
        } else {
            account.setBalance(account.getBalance() - amount);
            account.addTransaction(new Transaction("Withdraw", amount));
            bank.saveAccounts();
            bank.saveTransactions();
            System.out.println("Successfully withdrawn Rs. " + amount);
            System.out.println("Remaining balance: Rs. " + account.getBalance());
        }
    }

    // Deposit money
    public void deposit() {
        System.out.println("\n===== Deposit =====");
        System.out.print("Enter amount to deposit: Rs. ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            account.setBalance(account.getBalance() + amount);
            account.addTransaction(new Transaction("Deposit", amount));
            bank.saveAccounts();
            bank.saveTransactions();
            System.out.println("Successfully deposited Rs. " + amount);
            System.out.println("New balance: Rs. " + account.getBalance());
        }
    }

    // Transfer money
    public void transfer() {
        System.out.println("\n===== Transfer =====");
        System.out.print("Enter recipient's User ID: ");
        String recipientID = scanner.next();

        if (!bank.accountExists(recipientID)) {
            System.out.println("Account not found!");
            return;
        }

        if (recipientID.equals(account.getUserID())) {
            System.out.println("Cannot transfer to your own account!");
            return;
        }

        System.out.print("Enter amount to transfer: Rs. ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            Account recipient = bank.getAccount(recipientID);
            boolean success = bank.transfer(account, recipient, amount);
            if (success) {
                System.out.println("Successfully transferred Rs. " + amount + " to " + recipientID);
                System.out.println("Remaining balance: Rs. " + account.getBalance());
            } else {
                System.out.println("Insufficient balance!");
            }
        }
    }
}