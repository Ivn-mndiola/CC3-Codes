/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banksystem;

// Parent Class

class BankAccount {

    protected String accountNumber;

    protected double balance;

 

    // Constructor

    public BankAccount(String accountNumber, double balance) {

        this.accountNumber = accountNumber;

        this.balance = balance;

    }

 

    // Deposit method (common to all accounts)

    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

            System.out.printf("Deposited: %,.2f\n" + amount);

        } else {

            System.out.println("Invalid deposit amount.");

        }

    }

 

    // Withdraw method (overridden in child classes)

    public void withdraw(double amount) {

        System.out.println("Withdraw method should be implemented in specific account types.");

    }

 

    // Display account info

    public void displayAccountInfo() {

        System.out.println("Account Number: " +accountNumber);

        System.out.printf("Balance: %,.2f\n" ,balance);

    }

}

 

// Child Class: Savings Account
class SavingsAccount extends BankAccount {
    private double interestRate;
    private double withdrawalLimit = 5000; // Max withdrawal per transaction

    // Constructor
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Apply interest
    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest Applied: " + interest);
    }

 

   

// Withdraw method (restricted)

    @Override

    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {

            if (amount > withdrawalLimit) {

                System.out.println("Withdrawal exceeds the limit for savings accounts.");

            } else {

                balance -= amount;

                System.out.printf("Withdrawn: %,.2f\n" , amount);

            }

        } else {

            System.out.println("Invalid withdrawal amount.");

        }

    }

 

    // Display additional info
    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

 

 

// Child Class: Checking Account

class CheckingAccount extends BankAccount {

    private double minimumBalance = 1000; // Must maintain at least this balance

 

    // Constructor

    public CheckingAccount(String accountNumber, double balance) {

        super(accountNumber, balance);

    }

 

    // Withdraw method (with minimum balance check)

    @Override

    public void withdraw(double amount) {

        if (amount > 0 && (balance - amount) >= minimumBalance) {

            balance -= amount;

            System.out.printf("Withdrawn: %,.2f\n" , amount);

        } else {

            System.out.println("Cannot withdraw. Minimum balance must be maintained.");

        }

    }

 

    // Display additional info

    @Override

    public void displayAccountInfo() {

        super.displayAccountInfo();

        System.out.printf("Minimum Balance Required: %,.2f\n" , minimumBalance);

    }

}


public class BankSystem {

    public static void main(String[] args){
        
        SavingsAccount sa = new SavingsAccount("SAV-001", 100000, 3.5);
        sa.displayAccountInfo();
        sa.applyInterest();
        sa.withdraw(6000);
        sa.withdraw(4000);
        sa.displayAccountInfo();
        
        System.out.println(" ");
        
        CheckingAccount ca = new CheckingAccount("SAV-001", 100000);
        ca.displayAccountInfo();
        ca.withdraw(5000);
        ca.withdraw(1000);
        ca.displayAccountInfo();
    }
    
}
