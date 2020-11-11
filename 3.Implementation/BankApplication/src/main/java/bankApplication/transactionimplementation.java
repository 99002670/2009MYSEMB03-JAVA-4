package bankApplication;

class transactionimplementation implements transaction
{
	public double withdraw(double balance,int withdraw)
	{
	if(balance >= withdraw)
	{
		balance = balance - withdraw;
		System.out.println("Processing Withdrawal Transaction........Please collect the amount");
		return(balance);
	}
	else
	{
	System.out.println("Insufficient Balance");
	return(balance);
	}
	}
	
	public double deposit(double balance, int deposit)
	{
		return(balance += deposit);	
	}
	
	public double balancecheck(double balance)
	{
		return(balance);
	}
}