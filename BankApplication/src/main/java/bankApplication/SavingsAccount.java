package bankApplication;

public class SavingsAccount extends Account {
	static private double annualInterestRate;
    private double savingBalance;
    int balance;
    SavingsAccount(int num,String name,double savingBalance,double newInterestRate)
    {
        super(num,name);					
        this.savingBalance = savingBalance;
	        SavingsAccount.annualInterestRate = newInterestRate;
    }
    void display()
    {
        System.out.println("Savings Account Details --- ");
        System.out.println("Number : "+number);
        System.out.println("Name   : "+name);
        System.out.println("Balance : "+savingBalance);
    }
    void calculate()
    {
	    double monthlyI; 
        monthlyI= (double)(this.savingBalance*annualInterestRate/12);
        this.savingBalance+=monthlyI;
    }
}
