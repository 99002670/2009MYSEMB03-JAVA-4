package bankApplication;

abstract class Account {
	protected String accountNumber;
	protected String name;

	Account(String accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}

	abstract void display();
}
