package bankApplication;

class FixedDeposit extends Account {
	double amount;
	final double interestRate = 0.06;
	int duration;
	double maturityAmount;
	double balance;

	FixedDeposit(String accountNumber, String name, double amount, int duration) {
		super(accountNumber, name);
		this.amount = amount;
		this.duration = duration;
		this.balance = this.amount;
	}

	void display() {
		System.out.println("Fixed Deposit Account Details --- ");
		System.out.println("Number : " + this.accountNumber);
		System.out.println("Name   : " + this.name);
		System.out.println("Amount : " + this.amount);
		System.out.println("Duration in Years: " + this.duration);
		System.out.println("Account Balance : " + Math.round(this.balance));

	}

	void calculate() {
		double r = 1 + this.interestRate / 400;
		double m = (double) Math.pow(r, this.duration) - 1;
		double m1 = m * this.amount;
		double m2 = 1 / (double) Math.pow(r, .33);
		double m3 = 1 - m2;
		double maturityAmount = m1 / m3;
		this.balance = maturityAmount + this.balance;
	}
}
