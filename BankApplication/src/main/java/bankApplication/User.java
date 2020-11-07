package bankApplication;

import java.util.Scanner;

public class User {
	private String name;
	private String password;
	private String accountNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void transaction() {
		 System.out.println("Welcome To the Transaction");
		 int balance=5000, withdraw, deposit;
		 Scanner s = new Scanner(System.in);
		 while(true)
	     {
		 System.out.println("Press 1: To Deposit an Amount");
		 System.out.println("Press 2: To Withdraw Money");
		 System.out.println("Press 3: To Check the Balance remaining");
		 System.out.println("Press 4: To EXIT and END the Transaction");
		 System.out.println("..................................................");
		 System.out.print("Choose the operation you want to perform:");
		 int n = s.nextInt();
		 System.out.println("..................................................");
		 switch(n)
		 {
		 case 1:
		 transactionimplementation t = new transactionimplementation();
		 Scanner d = new Scanner(System.in);
		 System.out.println("Enter money to be deposited:-");
		 deposit = d.nextInt();
		 balance = t.deposit(1000,deposit);
		 System.out.println("Your Money has been successfully deposited......Thank you");
		 System.out.println("Balance Left:" + balance);
		 System.out.println("..................................................");
		 System.out.println("..................................................");
		 break;
		 
		 case 2:
		 transactionimplementation t1 = new transactionimplementation();
		 Scanner w = new Scanner(System.in);
		 System.out.print("Enter the amount to be withdrawn:");
		 withdraw = w.nextInt();
		 balance = t1.withdraw(balance, withdraw);
		 System.out.println("Balance Left:" + balance);
		 System.out.println("..................................................");
		 System.out.println("..................................................");
		 break;
		 
		 case 3:
		 transactionimplementation t2 = new transactionimplementation();
		 balance=(t2.balancecheck(balance));
		 System.out.println("Balance Left:" + balance);
		 System.out.println("..................................................");
		 System.out.println("..................................................");
		 break;
		 
		 case 4:
		 System.exit(0);
		}
		}
	}
	public void viewBalance() {
		
	}
	public void viewPassbook() {
		
	}
	public void options() {
		System.out.println(accountNumber + "  " + name + "  " + password);
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("#########USER#########");
			System.out.println("1. Transaction");
			System.out.println("2. View balance");
			System.out.println("3. View passbook");
			System.out.println("4. Exit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				transaction();
				break;
			case 2:
				viewBalance();
				break;
			case 3:
				viewPassbook();
				break;
			case 4:
				System.out.println("Exiting");
				break;
			default:
				break;					
			}
		}while(choice != 4);
	}

}
