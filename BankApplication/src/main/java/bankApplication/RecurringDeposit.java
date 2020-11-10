package bankApplication;

class RecurringDeposit extends Account {
	protected double amount;
	final double interestRate = 0.05;
	protected int tenure;
	double recurringAmount;
	double recurringInterest;

	RecurringDeposit(String accountNumber, String name, double amount, int durationYears) {
		super(accountNumber, name);
		this.amount = amount;
		this.tenure = durationYears;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTenure() {
		return this.tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getRecurringAmount() {
		return this.recurringAmount;
	}

	public void setRecurringAmount(double recurringAmount) {
		this.recurringAmount = recurringAmount;
	}

	public double getRecurringInterest() {
		return this.recurringInterest;
	}

	public void setRecurringInterest(double recurringInterest) {
		this.recurringInterest = recurringInterest;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	void display() {
		System.out.println("Recurring Deposit Account Details --- ");
		System.out.println("Number : " + this.getAccountNumber());
		System.out.println("Name   : " + this.getName());
		System.out.println("Amount : " + this.getAmount());
		System.out.println("Recurring deposit: " + Math.round(this.getRecurringAmount()));
		System.out.println("Interest Earned Amount: " + Math.round(this.getRecurringInterest()));
	}

	void calculate() {
		double temp = 1 + this.getInterestRate();
		this.setRecurringAmount(this.getAmount() * Math.pow(temp, this.getTenure()));
		this.setRecurringInterest(this.getRecurringAmount() - this.getAmount());

	}
}
