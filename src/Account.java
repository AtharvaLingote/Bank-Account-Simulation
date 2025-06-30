// src/Account.java

import java.io.*;
import java.util.ArrayList;

public class Account {
    protected String accountHolder;
    protected String accountNumber;
    protected double balance;
    protected ArrayList<String> transactionHistory;

    private static final String TRANSACTION_FILE = "data/transactions.txt";
    private static final String BALANCE_FILE = "data/balance.txt";

    public Account(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.transactionHistory = new ArrayList<>();
        this.balance = loadBalance(); // Load balance from file at start
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(" Deposit amount must be positive.");
            return;
        }
        balance += amount;
        String transaction = "Deposited ₹" + amount;
        transactionHistory.add(transaction);
        writeToFile(transaction);
        saveBalance();
        System.out.println(" " + transaction);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println(" Insufficient balance.");
            return;
        }
        balance -= amount;
        String transaction = "Withdrew ₹" + amount;
        transactionHistory.add(transaction);
        writeToFile(transaction);
        saveBalance();
        System.out.println(" " + transaction);
    }

    public void viewBalance() {
        System.out.println(" Current Balance: ₹" + balance);
    }

    public void viewTransactionHistory() {
        System.out.println("\n Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions this session.");
        } else {
            for (String t : transactionHistory) {
                System.out.println("- " + t);
            }
        }
    }

    protected void writeToFile(String transaction) {
        try (FileWriter fw = new FileWriter(TRANSACTION_FILE, true)) {
            fw.write(transaction + System.lineSeparator());
        } catch (IOException e) {
            System.out.println(" Error writing to transaction file: " + e.getMessage());
        }
    }

    protected void saveBalance() {
        try (FileWriter fw = new FileWriter(BALANCE_FILE)) {
            fw.write(String.valueOf(balance));
        } catch (IOException e) {
            System.out.println(" Error saving balance: " + e.getMessage());
        }
    }

    protected double loadBalance() {
        File file = new File(BALANCE_FILE);
        if (!file.exists()) {
            return 0.0;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            return line != null ? Double.parseDouble(line) : 0.0;
        } catch (IOException | NumberFormatException e) {
            System.out.println(" Error loading balance. Starting from ₹0.0");
            return 0.0;
        }
    }
}
