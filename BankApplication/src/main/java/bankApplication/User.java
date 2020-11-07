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
