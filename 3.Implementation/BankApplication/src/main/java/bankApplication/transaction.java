package bankApplication;

public interface transaction {
	public double withdraw(double balance, int withdraw);
	public double deposit(double balance, int deposit);
	public double balancecheck(double balance);
}
