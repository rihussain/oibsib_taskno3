import java.util.*;
public class ATM3
{
	private double balance;
    private ArrayList<String> transactionHistory;
	Scanner scanner = new Scanner(System.in);
		//user verification
		public void start()
		{
			
		
		System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();
	if (authenticateUser(userPin)) {
            System.out.println("Welcome, " + userId + "!");
            System.out.println("ATM Functionalities Unlocked");
            menuOptions();
        } else {
            System.out.println("Invalid User ID or PIN. Try again.");
            start();
        }
}
	    private boolean authenticateUser(String userPin) {
	    if(userPin.equals("xxxx"))
			return true;
	    else
	       return false;
		}
		public void menuOptions()
		{
			ATM3 myAtm = new ATM3();
		 while (true) {
            System.out.println("1. Deposit\n2. Withdraw\n3. Transfer\n4. Transaction History\n5.Balance\n6. Quit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    myAtm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    myAtm.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Enter transfer amount:");
                    double transferAmount = scanner.nextDouble();
                    // Create another ATM object for the sake of example
                    ATM3 otherAtm = new ATM3();
                    myAtm.transfer(transferAmount, otherAtm);
                    break;
                case 4:
                    myAtm.printTransactionHistory();
                    break;
				case 5:
						myAtm.balance();
						break;
                case 6:
					System.out.println("Thank you for using our services.Your transaction has been successfully completed.\nHave a great day!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        }
		}
		//operations

    public  ATM3() {
        this.balance = 500;      //default 500
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.transactionHistory.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        this.balance -= amount;
        this.transactionHistory.add("Withdrew: " + amount);
    }

    public void transfer(double amount, ATM3 other) {
        if (amount > this.balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        this.withdraw(amount);
        other.deposit(amount);
        this.transactionHistory.add("Transferred: " + amount);
    }

    public void printTransactionHistory() {
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
	public void balance()
	{
	System.out.println("\nBalance: "+this.balance);
	}

	public static void main(String[] args)
	{
		
		 ATM3 myst = new ATM3();
		 myst.start();
		
		
	}
}