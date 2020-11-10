package bankApplication;

class RecurringDeposit extends Account {
	protected double amount;
	final double interestRate = 0.05;
	protected double tenure;
	double A, I;

	RecurringDeposit(String accountNumber, String name, double amount, double durationYears) {
		super(accountNumber, name);
		this.amount = amount;
		this.tenure = durationYears;
	}

	void display() {
		System.out.println("Recurring Deposit Account Details --- ");
		System.out.println("Number : " + this.accountNumber);
		System.out.println("Name   : " + this.name);
		System.out.println("Amount : " + this.amount);
		System.out.println("Recurring deposit: " + Math.round(A));
		System.out.println("Interest Earned Amount: " + Math.round(I));
	}

	void calculate() {
		double temp;
		this.amount = 15000;
		this.tenure = 2;
		temp = 1 + this.interestRate;
		A = this.amount * Math.pow(temp, this.tenure);
		I = A - this.amount;

	}
}
