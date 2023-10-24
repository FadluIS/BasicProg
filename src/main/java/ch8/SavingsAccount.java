package ch8;

public class SavingsAccount implements Showable{
    private long accountNumber;
    private double balance;
    private double interestRate;
    private static long lastIssuedAccountNumber = 900001244213l;


    public SavingsAccount(double interestRate) {
        this.balance = 0;
        this.interestRate = interestRate;
        this.accountNumber = issueAccountNumber();
        Utilities.show(this);
    }

    private long issueAccountNumber() {
        return ++lastIssuedAccountNumber;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount should be higher than 0");
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid withdraw amount: Cannot be negative.");
        }

        if (amount > this.balance) {
            throw new RuntimeException("Invalid withdraw amount: Insufficient balance.");
        }

        balance -= amount;
    }
    public double getYield(int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Yield term must be positive.");
        }

        return Math.pow(balance * (1 + interestRate), years);
    }
    public void addAnnualInterest() {
        balance += balance * interestRate;
    }

    public long getAccountNumber() { return this.accountNumber; }

    public double getBalance() {
        return this.balance;
    }

    public double getInterestRate() {
        return this.interestRate;
    }


    @Override
    public void show() {
        System.out.format("Account Number: %s%nBalance: %.2f %nInterest Rate: %.2f %n",
                getAccountNumber(), getBalance(), getInterestRate() * 100);
    }
}
