package bankApplication;

abstract class Account {
	protected String accountNumber;
	protected String name;

	Account(String accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	abstract void display();
}
