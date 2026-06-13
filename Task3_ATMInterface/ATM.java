package Task3_ATMInterface;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("================================");
        System.out.println("   Welcome to Bilal's ATM 🏧   ");
        System.out.println("================================");

        // Login
        System.out.print("Enter User ID: ");
        String userID = scanner.next();

        if (!bank.accountExists(userID)) {
            System.out.println("Account not found! Exiting...");
            return;
        }

        System.out.print("Enter PIN: ");
        String pin = scanner.next();

        Account account = bank.getAccount(userID);

        if (!account.validatePin(pin)) {
            System.out.println("Invalid PIN! Exiting...");
            return;
        }

        System.out.println("\nWelcome, " + userID + "! 👋");
        System.out.println("Current Balance: Rs. " + account.getBalance());

        // ATM Operations
        ATMOperations operations = new ATMOperations(account, bank);

        // Main Menu Loop
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n======= ATM Menu =======");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    operations.showTransactionHistory();
                    break;
                case 2:
                    operations.withdraw();
                    break;
                case 3:
                    operations.deposit();
                    break;
                case 4:
                    operations.transfer();
                    break;
                case 5:
                    System.out.println("\nThank you for using Bilal's ATM!");
                    System.out.println("Goodbye! 👋");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}