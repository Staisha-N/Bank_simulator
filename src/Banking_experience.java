import java.util.Scanner;

public class Banking_experience {
	int current_balance;
	int last_transaction;
	String user_name;
	String user_ID;
	
	//class constructor code
	Banking_experience(String cname, String cID) {
		user_name = cname;
		user_ID = cID;
	}
	
	//Option 1: Deposit money
	void deposit (int amount) {
		if (amount != 0) {
			current_balance += amount;
			last_transaction = amount;
		}
	}
	
	//Option 2: Withdraw money
	void withdraw (int amount) {
		if (amount != 0) {
			current_balance -= amount;
			last_transaction = -amount;
		}
	}
	
	//Option 3: Show last transaction
	void get_last () {
		if (last_transaction > 0) {
			System.out.println("Deposited: " + last_transaction);
		} else if (last_transaction < 0) {
			System.out.println("Withdrew: " + Math.abs(last_transaction));
		} else {
			System.out.println("No transaction occured.");
		}
	}
	
	//Option 4: Calculate interest on funds after a specified period
	void get_interest (int years) {
		double rate = .0185;
		double increase_balance = (current_balance * rate * years) + current_balance;
		System.out.println("The interest rate is " + (100*rate) + "%");
		System.out.println("After " + years + " years, your balance will be: " + increase_balance);
	}
	//Option 5: Show options
	void show_options() {
		char choice = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + user_name + "!");
		System.out.println("Your ID is: " + user_ID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter your choice: ");
			char primitive = scanner.next().charAt(0);
			choice = Character.toUpperCase(primitive);
			System.out.println();
			
			switch(choice) {
			
			case 'A':
				System.out.println("====================================");
				System.out.println("Balance = $" + current_balance);
				System.out.println("====================================");
				System.out.println();
				break;
			
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
			
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			
			case 'D':
				System.out.println("====================================");
				get_last();
				System.out.println("====================================");
				System.out.println();
				break;
			
			case 'E':
				System.out.println("Enter how many years of accrued interest: ");
				int years = scanner.nextInt();
				get_interest(years);
				break;
			
			case 'F':
				System.out.println("====================================");
				break;
				
			// the user has entered an invalid character
			default:
				System.out.println("Error: invalid input. Please enter A, B, C, D, or E.");
				break;
			}
		} while(choice != 'F');
		System.out.println("Thank you for banking with us!");
	
			
			
		
	}

}
