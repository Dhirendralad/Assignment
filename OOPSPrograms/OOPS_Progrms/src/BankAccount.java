public class BankAccount {
    private double balance;
    private String accountNumber;

    // Constructor
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        } else {
            System.out.println("Invalid amount. Withdrawal failed.");
        }
    }

    // Method to print account information
    public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    // Main method to test the BankAccount class
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account = new BankAccount("10050064646548");

        // Deposit money
        account.deposit(354164.0);

        // Withdraw money
        account.withdraw(21652.0);

        // Print account information
        account.printAccountInfo();
    }
}
