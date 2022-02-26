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

	private boolean checkingConflict(Account account)
	{
		return !(find(account) == -1);
	}

	public boolean open(Account account)
	{
		if(numAcct == accounts.length) 
		{
			grow();
		}

		if(account.getType().equals("Checking") || account.getType().equals("College Checking"))
		{
			if(checkingConflict(account)) return false;
		}

		accounts[numAcct++] = account;
		return true;
	}

	public boolean close(Account account)
	{
		account.close();
		return false;
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
		for(int i = 0; i < numAcct; i++)
		{
			Account a = accounts[i];
			System.out.println(a.toString());
		}
	}
	
	public void printFeeAndInterest() 
	{
		
	}

	public void printByAccountType() { }

//	public void printFeeAndInterest() { }
}
