package bankApplication;

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