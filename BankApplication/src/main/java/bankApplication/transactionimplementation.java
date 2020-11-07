package bankApplication;

class transactionimplementation implements transaction
{
	public int withdraw(int balance,int withdraw)
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
	
	public int deposit(int balance, int deposit)
	{
		return(balance += deposit);	
	}
	
	public int balancecheck(int balance)
	{
		return(balance);
	}
}