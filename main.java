import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

   
    public void displayOptions() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    
    public void withdraw(double amount) {
        if (validateInput(amount) && amount <= bankAccount.getBalance()) {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            displayMessage("Withdrawal successful. Remaining balance: " + bankAccount.getBalance());
        } else {
            displayMessage("Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (validateInput(amount)) {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            displayMessage("Deposit successful. New balance: " + bankAccount.getBalance());
        } else {
            displayMessage("Deposit failed. Invalid amount.");
        }
    }

    public void checkBalance() {
        displayMessage("Current balance: " + bankAccount.getBalance());
    }

    private boolean validateInput(double amount) {
        return amount > 0;  
    }

   
    public void displayMessage(String message) {
        System.out.println(message);
    }
}

class Main {
    public static void main(String[] args) {
       
        BankAccount bankAccount = new BankAccount(1000.0);
        ATM atm = new ATM(bankAccount);

        Scanner scanner = new Scanner(System.in);
    
   
     do {
            atm.displayOptions();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    atm.displayMessage("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    atm.displayMessage("Invalid choice. Please try again.");
                    break;
            }
        } while (true);  
    }
}