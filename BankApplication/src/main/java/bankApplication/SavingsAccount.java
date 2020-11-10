package bankApplication;

public class SavingsAccount extends Account {
	final private double annualInterestRate = 0.04;
	private double balance;

	SavingsAccount(String accountNumber, String name, double balance) {
		super(accountNumber, name);
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	void display() {
		System.out.println("Savings Account Details --- ");
		System.out.println("Account number : " + this.getAccountNumber());
		System.out.println("Name   : " + this.getName());
		System.out.println("Balance : " + this.getBalance());
	}

	void calculate() {
		double monthlyI;
		monthlyI = this.getBalance() * this.getAnnualInterestRate() / 12;
		this.setBalance(this.getBalance() + monthlyI);
	}
}
