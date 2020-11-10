package bankApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
	private String name;
	private String password;
	private String accountNumber;
	private double balance;
	Account account;

	public double getBalance() throws IOException {
		FileReader reader = null;
		BufferedReader bReader = null;
		try {
			reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/UserData.txt");
			bReader = new BufferedReader(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = null;
		while ((line = bReader.readLine()) != null) {
			String elements[] = line.split(",");
			if (line.contains(this.name)) {
				bReader.close();
				reader.close();
				return Double.parseDouble(elements[3]);
			}
		}
		bReader.close();
		reader.close();
		return this.balance;
	}

	public void setBalance(double balance) throws IOException {
		FileReader reader = null;
		BufferedReader bReader = null;
		FileWriter writer = null;
		BufferedWriter bWriter = null;
		try {
			reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/UserData.txt");
			bReader = new BufferedReader(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			writer = new FileWriter(System.getProperty("user.dir") + "/src/main/resources/temp.txt", true);
			bWriter = new BufferedWriter(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String line;
		while ((line = bReader.readLine()) != null) {
            if (line.contains(this.name)) {
            	String elements[] = line.split(",");
               line = line.replace(elements[3], "" + balance);
            }
            bWriter.write(line+"\n");
         }
		bReader.close();
		reader.close();
		bWriter.close();
		writer.close();
		File oldFile = new File(System.getProperty("user.dir") + "/src/main/resources/UserData.txt");
	      oldFile.delete();

	      // And rename tmp file's name to old file name
	      File newFile = new File(System.getProperty("user.dir") + "/src/main/resources/temp.txt");
	      newFile.renameTo(oldFile);
		this.balance = balance;
	}

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

	public void setAccount(String accountType) {
		Scanner scanner = new Scanner(System.in);
		if (accountType.equalsIgnoreCase("Savings")) {
			this.account = new SavingsAccount(this.accountNumber, this.name, this.balance);
		} else if (accountType.equalsIgnoreCase("Recurring")) {
			System.out.println("Enter duration: ");
			int durationYears = Integer.parseInt(scanner.nextLine());
			this.account = new RecurringDeposit(accountNumber, name, balance, durationYears);
		} else if (accountType.equalsIgnoreCase("Fixed")) {
			System.out.println("Enter duration: ");
			int duration = Integer.parseInt(scanner.nextLine());
			this.account = new FixedDeposit(this.accountNumber, this.name, this.balance, duration);
		} else {
			System.out.println("***Invlid account type***");
		}

	}

	public void transaction() throws IOException {
		System.out.println("Welcome To the Transaction");
		int withdraw, deposit;
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Press 1: To Deposit an Amount");
			System.out.println("Press 2: To Withdraw Money");
			System.out.println("Press 3: To Check the Balance remaining");
			System.out.println("Press 4: To EXIT and END the Transaction");
			System.out.println("..................................................");
			System.out.print("Choose the operation you want to perform:");
			choice = scanner.nextInt();
			System.out.println("..................................................");
			switch (choice) {
			case 1:
				transactionimplementation t = new transactionimplementation();
				Scanner d = new Scanner(System.in);
				System.out.println("Enter money to be deposited:-");
				deposit = d.nextInt();
				this.setBalance(t.deposit(this.getBalance(), deposit));
				System.out.println("Your Money has been successfully deposited......Thank you");
				System.out.println("Balance Left:" + this.balance);
				System.out.println("..................................................");
				System.out.println("..................................................");
				break;

			case 2:
				transactionimplementation t1 = new transactionimplementation();
				Scanner w = new Scanner(System.in);
				System.out.print("Enter the amount to be withdrawn:");
				withdraw = w.nextInt();
				this.setBalance(t1.withdraw(this.getBalance(), withdraw));
				System.out.println("Balance Left:" + this.balance);
				System.out.println("..................................................");
				System.out.println("..................................................");
				break;

			case 3:
				transactionimplementation t2 = new transactionimplementation();
				this.balance = (t2.balancecheck(this.getBalance()));
				System.out.println("Balance Left:" + this.getBalance());
				System.out.println("..................................................");
				System.out.println("..................................................");
				break;

			case 4:
				System.out.println("Transactions complete");
				break;
			default:
				System.out.println("***Invalid entry, try again***");		
			}
		}while(choice != 4);
	}

	public void viewBalance() throws IOException {
		System.out.println("Current balance: " + this.getBalance());
	}

	public void viewAccountDetails() {
		this.account.display();
	}

	public void options() throws IOException {
		System.out.println(accountNumber + "  " + name + "  " + password);
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("#########USER#########");
			System.out.println("1. Transaction");
			System.out.println("2. View balance");
			System.out.println("3. View account details");
			System.out.println("4. Exit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				transaction();
				break;
			case 2:
				viewBalance();
				break;
			case 3:
				viewAccountDetails();
				break;
			case 4:
				System.out.println("Exiting");
				break;
			default:
				break;
			}
		} while (choice != 4);
	}

}
