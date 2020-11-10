package bankApplication;

public class SavingsAccount extends Account {
	final private double annualInterestRate = 0.04;
	private double balance;

	SavingsAccount(String accountNumber, String name, double balance) {
		super(accountNumber, name);
		this.balance = balance;
	}

	void display() {
		System.out.println("Savings Account Details --- ");
		System.out.println("Account number : " + this.accountNumber);
		System.out.println("Name   : " + this.name);
		System.out.println("Balance : " + this.balance);
	}

	void calculate() {
		double monthlyI;
		monthlyI = (double) (this.balance * annualInterestRate / 12);
		this.balance += monthlyI;
	}
}
