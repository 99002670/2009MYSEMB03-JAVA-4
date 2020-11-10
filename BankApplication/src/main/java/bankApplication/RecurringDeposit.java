package bankApplication;

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
