import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a SavingsAccount
        System.out.print(" Enter your name: ");
        String name = scanner.nextLine();

        System.out.print(" Enter account number: ");
        String accNum = scanner.nextLine();

        SavingsAccount account = new SavingsAccount(name, accNum);

        boolean running = true;

        while (running) {
            System.out.println("\n Bank Account Menu");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print(" Enter amount to deposit: ₹");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                }
                case 2 -> {
                    System.out.print("💸 Enter amount to withdraw: ₹");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount); 
                }
                case 3 -> account.viewBalance();
                case 4 -> account.viewTransactionHistory();
                case 5 -> {
                    running = false;
                    System.out.println("Thank you for using the Bank App!");
                }
                default -> System.out.println(" Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}