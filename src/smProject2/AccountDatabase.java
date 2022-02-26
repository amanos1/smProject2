package smProject2;

public class AccountDatabase 
{
	private Account [] accounts;
	private int numAcct;

	private final static int GROW_AMOUNT = 4;

	public AccountDatabase() 
	{
		accounts = new Account[GROW_AMOUNT];
		numAcct = 0;
	}

	private int find(Account account)
	{
		for(int i = 0; i < numAcct; i++) 
		{
			if(accounts[i].equals(account)) 
			{
				return i;
			}
		}
		return -1;
	}

	private void grow() 
	{
			Account [] temp = new Account[accounts.length + GROW_AMOUNT];
			for(int i = 0; i < numAcct; i++) 
			{
				temp[i] = accounts[i];
			}
			accounts = temp;
		
	}

	private boolean checkingConflict(Checking account)
	{
		if(account.getType().equals("Checking"))
		{
			CollegeChecking cc = new CollegeChecking(account.getHolder(), 1, 0);
			return !(find(cc) == -1);
		} else
		{
			Checking c = new Checking(account.getHolder());
			return !(find(c) == -1);
		}
	}

	public boolean open(Account account)
	{
		if(numAcct == accounts.length) 
		{
			grow();
		}

		if(!(find(account) == -1)) return false;

		if(account.getType().equals("Checking") || account.getType().equals("College Checking"))
		{
			if(checkingConflict((Checking) account)) return false;
		}

		accounts[numAcct++] = account;
		return true;
	}

	public boolean close(Account account)
	{
		account.close();
		return false;
		/*
		 * There are two errors:
		 * The account does not exist
		 * The account exists but is already closed
		 */
	}

	public void deposit(Account account) { }

	public boolean withdraw(Account account)
	{
		return false;
	} //return false if insufficient fund

	/**
	 * Prints info about all the accounts in the system to the console.
	 * Prints in whatever order they may be in.
	 */
	public void print() {
		if(numAcct == 0)
		{
			System.out.println("Account Database is empty!");
			return;
		}

		System.out.println("\n*list of accounts in the database*");

		for(int i = 0; i < numAcct; i++)
		{
			Account a = accounts[i];
			System.out.println(a.toString());
		}

		System.out.println("*end of list.\n");
	}
	
	/**
	 * Prints the same info as the print() method plus the monthly interest and fee for each account in the system.
	 * Prints in whatever order they may be in.
	 */
	public void printFeeAndInterest() 
	{
		if(numAcct == 0)
		{
			System.out.println("Account Database is empty!");
			return;
		}

		System.out.println("\n*list of accounts with fee and monthly interest");

		for(int i = 0; i < numAcct; i++)
		{
			Account a = accounts[i];
			System.out.printf("%s::fee $%.2f::monthly interest $%.2f\n", a, a.fee(), a.monthlyInterest());
		}

		System.out.println("*end of list.\n");
	}

	/**
	 * Sorts the accounts in the system by account type and prints them to the console.
	 * If two accounts are the same type, it does not matter which order they are in.
	 */
	public void printByAccountType()
	{
		if(numAcct == 0)
		{
			System.out.println("Account Database is empty!");
			return;
		}

		for(int i = 0; i < numAcct; i++)
		{
			for(int j = i + 1; j < numAcct; j++)
			{
				if(accounts[i].getType().compareTo(accounts[j].getType()) > 0)
				{
					swap(i, j);
				}
			}
		}

		System.out.println("\n*list of accounts with fee and monthly interest");

		for(int i = 0; i < numAcct; i++)
		{
			Account a = accounts[i];
			System.out.println(a.toString());
		}

		System.out.println("*end of list.\n");
	}

	/**
	 * Swaps elements a and b in the accounts array.
	 * For use with the printByAccountType() method.
	 * @param a First element to be swapped.
	 * @param b Second element to be swapped.
	 */
	private void swap(int a, int b)
	{
		Account temp = accounts[a];
		accounts[a] = accounts[b];
		accounts[b] = temp;
	}

}
