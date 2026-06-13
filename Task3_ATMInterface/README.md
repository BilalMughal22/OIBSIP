# Task 3 - ATM Interface

## Description
A console-based ATM application built in Java with 5 classes.

## Classes
- ATM.java - Main class, runs the program
- Account.java - Stores user data and balance
- Transaction.java - Represents each transaction
- Bank.java - Manages all accounts and file storage
- ATMOperations.java - Handles withdraw, deposit, transfer

## Features
- Login with User ID and PIN
- View Transaction History
- Withdraw money
- Deposit money
- Transfer money between accounts
- Data persistence (balance saved after every transaction)

## Default Test Accounts
| User ID | PIN  | Balance    |
|---------|------|------------|
| bilal   | 1234 | Rs. 50,000 |
| ali     | 5678 | Rs. 30,000 |
| sara    | 9999 | Rs. 75,000 |

## How to Run
1. Compile: javac Task3_ATMInterface/*.java
2. Run: java Task3_ATMInterface.ATM