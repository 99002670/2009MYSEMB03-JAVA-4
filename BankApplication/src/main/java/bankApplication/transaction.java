package bankApplication;

public interface transaction {
	public int withdraw(int balance, int withdraw);
	public int deposit(int balance, int deposit);
	public int balancecheck(int balance);
}
