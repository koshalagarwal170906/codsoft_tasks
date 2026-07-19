import java.util.Scanner;

// Class representing the user's Bank Account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited: $%.2f%n", amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }

        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew: $%.2f%n", amount);
            return true;
        } else {
            System.out.println("Error: Insufficient funds.");
            return false;
        }
    }
}

// Class representing the ATM
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void startInterface() {
        Scanner scanner = new Scanner(System.in);

        // Initialize choice
        int choice = 0;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                scanner.next(); // discard invalid input
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: $%.2f%n", account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: $");
                    if (scanner.hasNextDouble()) {
                        double depositAmt = scanner.nextDouble();
                        account.deposit(depositAmt);
                    } else {
                        System.out.println("Invalid amount.");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    if (scanner.hasNextDouble()) {
                        double withdrawAmt = scanner.nextDouble();
                        account.withdraw(withdrawAmt);
                    } else {
                        System.out.println("Invalid amount.");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM service. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please select 1 to 4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}

// Main class
public class AtmInterface {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(500.00);

        ATM atmMachine = new ATM(userAccount);

        atmMachine.startInterface();
    }
}