# Task 3 - ATM Interface

## Description
A console based ATM application developed using java having total of 5 classes.

## Classes
- ATM.java - Main class that executes the code
- Account.java - Holds user information along with balance
- Transaction.java - For each transaction
- Bank.java - Holds all the accounts and manages files
- ATMOperations.java - Performs the withdraw, deposit, transfer operation

## Features
- Login into the system using user id and pin
- Transaction history viewing 
- Perform withdrawals
- Perform deposits
- Make transfers from one account to another account
- Persisting data (Balance is saved after every transaction)

## Test Accounts
| User ID | PIN  | Balance    |
|---------|------|------------|
| bilal   | 1234 | Rs. 50,000 |
| ali     | 5678 | Rs. 30,000 |
| sara    | 9999 | Rs. 75,000 |

## How to Run
1. Compilation Command: javac Task3_ATMInterface/*.java
2. Execution command: java Task3_ATMInterface.ATM