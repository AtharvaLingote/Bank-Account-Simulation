# 💳 Bank Account Simulation (Java)

A simple command-line Java application that simulates basic banking operations using Object-Oriented Programming (OOP) principles.

---

## 🧩 Features

- 🧍 Create a savings account with name and account number
- 💰 Deposit money
- 💸 Withdraw money (with minimum balance check)
- 📄 View current account balance
- 🕓 View transaction history (per session)
- 📝 Balance and transactions persist using file storage

---

## 🚀 Technologies Used

- Java
- File I/O (`FileWriter`, `BufferedReader`)
- OOP Concepts:
  - ✅ Classes
  - ✅ Inheritance
  - ✅ Method Overriding
- VS Code + Terminal

---

## 📁 Folder Structure

Task5
- src
  - Account.java
  - SavingsAccount.java
  - BankApp.java
- data/
  - balance.txt 
  - transactions.txt 
- .gitignore
- README.md

## 🛠️ Run Instructions

### 1. Compile

```
javac src/*.java
```

### 2. Run

```
java -cp src
```

## 🔐 Note on Persistence

- All transactions are logged in: data/transactions.txt
- Account balance is saved to: data/balance.txt

## 👨‍💻 Author
Atharva Lingote
GitHub: [@Atharvalingote](https://github.com/AtharvaLingote)
