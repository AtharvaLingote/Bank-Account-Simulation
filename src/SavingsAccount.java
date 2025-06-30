
public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 500.0;

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Withdrawal amount must be positive.");
            return;
        }

        if ((balance - amount) < MIN_BALANCE) {
            System.out.println(" Cannot withdraw. Minimum balance of ₹" + MIN_BALANCE + " must be maintained.");
            return;
        }

        balance -= amount;
        String transaction = "Withdrew ₹" + amount + " (SavingsAccount)";
        transactionHistory.add(transaction);
        writeToFile(transaction);
        System.out.println( transaction);
    }
}
