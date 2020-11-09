package bankApplication;
import java.lang.Math;
abstract class Account
{
        protected int number;
        protected String name;
        Account(int num, String name)
        {
            number=num;
            this.name=name;
        }
        abstract void display();
}


class SavingsAccount extends Account
{
        static private double annualInterestRate;
        private double savingBalance;
        int balance;
        SavingsAccount(int num,String name,double savingBalance,double newInterestRate)
        {
            super(num,name);					
            this.savingBalance = savingBalance;
  	        this.annualInterestRate = newInterestRate;
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



class RecurringDeposit extends Account
{
        protected double amount;
        protected double interestRate;
	    protected double tenure;
	    protected double no_of_times;
	    double A,I;
        RecurringDeposit(int no,String na,double amount,double interestRate,double no_of_times,double durationYears)
        {
            super(no,na);
            this.amount=amount;
            this.interestRate = interestRate;
	        this.no_of_times = no_of_times;
	        this.tenure = durationYears;
        }
        void display()
        {
            System.out.println("Recurring Deposit Account Details --- ");
            System.out.println("Number : "+number);
            System.out.println("Name   : "+name);
            System.out.println("Amount : "+this.amount);
        	System.out.println("Recurring deposit: "+ Math.round(A));
            System.out.println("Interest Earned Amount: "+ Math.round(I));
    	}
        void calculate()
	    {   
        	double temp;
        	this.amount =15000;
        	this.interestRate = 0.05;
        	this.tenure=2;
        	this.no_of_times=4;
        	temp=(1+this.interestRate/this.no_of_times);
        	A=this.amount*Math.pow(temp,(this.no_of_times*this.tenure));
        	I=A-this.amount;
        		
	    }

}

class FixedDeposit extends Account
{
        int amount;
        double interestRate;
        int duration;
        double maturityAmount;
        double balance;
        FixedDeposit(int no,String na,int amt,int duration,double interestRate)
        {
            super(no,na);
            this.amount = amt;
 	        this.interestRate = interestRate;
            this.duration=duration;
            this.balance = this.amount;
        }
        void display()
        {
            System.out.println("Fixed Deposit Account Details --- ");
            System.out.println("Number : "+number);
            System.out.println("Name   : "+name);
            System.out.println("Amount : "+amount);
            System.out.println("Duration in Years: "+this.duration);
            System.out.println("Account Balance : "+ Math.round(this.balance));
            
    	}
	void calculate()
	{
		double r = 1 + this.interestRate/400;
  		double m = (double)Math.pow(r, this.duration)-1;
  		double m1 = m*this.amount;
  		double m2 = 1/(double)Math.pow(r,.33);
  		double m3 = 1-m2;
  		double maturityAmount = m1/m3;
  		this.balance = maturityAmount+this.balance;
	}
}


public class BankDetails
{

public static void main(String args[])
{
    SavingsAccount sa=new SavingsAccount(101,"Bhakti Raul",15000,0.05);

    RecurringDeposit rd=new RecurringDeposit(405,"Samarth Rane",15000,0.05,4,2);

    FixedDeposit fd = new FixedDeposit(302,"Stavan Chavan",15000,4,0.05);

    System.out.println("Savings Account Details Before Calculation--- ");
    sa.display();
    System.out.println("Recurring Deposit Details Before Calculation--- ");
    rd.display();
    System.out.println("Fixed Deposit Details Before Calculation--- ");
    fd.display();

    sa.calculate();
    rd.calculate();
    fd.calculate();

    System.out.println("Savings Account Details After Calculation--- ");
    sa.display();
    System.out.println("Recurring Deposit Details After Calculation--- ");
    rd.display();
    System.out.println("Fixed Deposit Details After Calculation--- ");
    fd.display();

}
}