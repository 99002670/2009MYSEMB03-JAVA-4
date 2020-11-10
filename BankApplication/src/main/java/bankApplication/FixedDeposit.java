package bankApplication;

class FixedDeposit extends Account {
	final double interestRate = 0.06;
	double amount;
	int duration;
	double balance;

	FixedDeposit(String accountNumber, String name, double amount, int duration) {
		super(accountNumber, name);
		this.amount = amount;
		this.duration = duration;
		this.balance = this.amount;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	void display() {
		System.out.println("Fixed Deposit Account Details --- ");
		System.out.println("Number : " + this.getAccountNumber());
		System.out.println("Name   : " + this.getName());
		System.out.println("Amount : " + this.getAmount());
		System.out.println("Duration in Years: " + this.getDuration());
		System.out.println("Account Balance : " + Math.round(this.getBalance()));

	}

	void calculate() {
		double r = 1 + this.getInterestRate() / 400;
		double m = (double) Math.pow(r, this.getDuration()) - 1;
		double m1 = m * this.getAmount();
		double m2 = 1 / Math.pow(r, 0.33);
		double m3 = 1 - m2;
		double maturityAmount = m1 / m3;
		this.setBalance(this.getBalance() + maturityAmount);
	}
}
