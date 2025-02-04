package bankApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bank {
	User user;

	public Bank() {
		this.user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void register() throws NumberFormatException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter account number: ");
		this.user.setAccountNumber(scanner.nextLine());
		System.out.println("Enter name: ");
		this.user.setName(scanner.nextLine());
		while (true) {
			System.out.println("Enter password: ");
			String password = scanner.nextLine();
			System.out.println("Confirm password: ");
			String confirmPassword = scanner.nextLine();
			if (password.equals(confirmPassword)) {
				this.user.setPassword(password);
				break;
			} else {
				System.out.println("***Passwords don't match***");
			}
		}
		this.user.setBalance(0);
		System.out.println("###Types of accounts###");
		System.out.println("Savings");
		System.out.println("Recurring");
		System.out.println("Fixed");
		System.out.println("Enter account type: ");
//		this.user.setAccount(scanner.nextLine());
		String accountType = scanner.nextLine();
		FileWriter writer = null;
		BufferedWriter bWriter = null;
		try {
			writer = new FileWriter(System.getProperty("user.dir") + "/src/main/resources/temp.txt", true);
			bWriter = new BufferedWriter(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (accountType.equalsIgnoreCase("Savings")) {
			this.user.account = new SavingsAccount(this.user.getAccountNumber(), this.user.getName(), this.user.getBalance());
			bWriter.write("Savings");
			this.user.account.setAccountType("Savings");
		} else if (accountType.equalsIgnoreCase("Recurring")) {
			System.out.println("Enter duration: ");
			int durationYears = Integer.parseInt(scanner.nextLine());
			this.user.account = new RecurringDeposit(this.user.getAccountNumber(), this.user.getName(), this.user.getBalance(), durationYears);
			bWriter.write("Recurring");
			this.user.account.setAccountType("Recurring");
		} else if (accountType.equalsIgnoreCase("Fixed")) {
			System.out.println("Enter duration: ");
			int duration = Integer.parseInt(scanner.nextLine());
			this.user.account = new FixedDeposit(this.user.getAccountNumber(), this.user.getName(), this.user.getBalance(), duration);
			bWriter.write("Fixed");
			this.user.account.setAccountType("Fixed");
		} else {
			System.out.println("***Invalid account type***");
		}
	}

	public void login(BufferedReader bReader) throws IOException {
		Scanner scanner = new Scanner(System.in);
		boolean nameFlag = false;
		boolean passwordFlag = false;
		System.out.println("Enter name: ");
		user.setName(scanner.nextLine());
		System.out.println("Enter password: ");
		user.setPassword(scanner.nextLine());
		String line = null;
		while ((line = bReader.readLine()) != null) {
			String elements[] = line.split(",");
			if (user.getName().equals(elements[1])) {
				nameFlag = true;
				if (user.getPassword().equals(elements[2])) {
					user.setAccountNumber(elements[0]);
					passwordFlag = true;
				} else {
					passwordFlag = false;
				}
				break;
			} else {
				nameFlag = false;
			}
		}
		if (nameFlag && passwordFlag) {
			System.out.println("Login successful");
			user.options();
		} else if (nameFlag && !passwordFlag) {
			System.out.println("***Password does not match***");
		} else {
			System.out.println("***User does not exist***");
		}
	}

	public static void main(String args[]) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedReader bReader = null;
		BufferedWriter bWriter = null;
		FileReader reader = null;
		FileWriter writer = null;
//		try {
//			reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/UserData.txt");
//			System.out.println("reader");
//			bReader = new BufferedReader(reader);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

//		try {
//			writer = new FileWriter(System.getProperty("user.dir") + "/src/main/resources/UserData.txt");
//			System.out.println("writer");
//			bWriter = new BufferedWriter(writer);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		Bank bank = new Bank();

		int choice = 0;
		do {
			System.out.println("#########BANK#########");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Close");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("login");
				try {
					reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/UserData.txt");
					bReader = new BufferedReader(reader);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				bank.login(bReader);

				break;
			case 2:
				System.out.println("register");
				bank.register();
				try {
					writer = new FileWriter(System.getProperty("user.dir") + "/src/main/resources/UserData.txt", true);
					bWriter = new BufferedWriter(writer);
				} catch (IOException e) {
					e.printStackTrace();
				}
				bWriter.write(bank.user.getAccountNumber() + ",");
				bWriter.write(bank.user.getName() + ",");
				bWriter.write(bank.user.getPassword() + ",");
				bWriter.write(bank.user.getBalance() + ",");
				bWriter.write(bank.user.getAccount() + "\n");
				bWriter.flush();
				break;
			case 3:
				System.out.println("Thank you for banking with us");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid entry, try again");
				break;
			}
		} while (choice != 3);

		bReader.close();
		reader.close();
		bWriter.close();
		writer.close();
	}

}
