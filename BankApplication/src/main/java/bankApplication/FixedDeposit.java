package bankApplication;

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
