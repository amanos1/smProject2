package smProject2;

public class AccountDatabase 
{
	private Account [] accounts;
	private int numAcct;
	
	public AccountDatabase() 
	{
		accounts = new Account[4];
		numAcct = 0;
	}

	private int find(Account account)
	{
		for(int i = 0; i < accounts.length; i++) 
		{
			if(accounts[i].equals(account) && accounts[i] != null) 
			{
				return i;
			}
		}
		return -1;
	}

	private void grow() 
	{
			Account [] temp = new Account[accounts.length];
			for(int i = 0; i < accounts.length; i++) 
			{
				temp[i] = accounts[i];
			}
			accounts = temp;
		
	}

	public boolean open(Account account)
	{
		if(numAcct == accounts.length) 
		{
			grow();
		}
		for(int i = 0; i < accounts.length; i++) 
		{
			if(find(account) != -1) 
			{
				return false;
			}
			if(accounts[i] == null) 
			{
				accounts[i] = account;
			}
		}
		return true;
	}

	public boolean close(Account account)
	{
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
		for(Account a : accounts)
		{
			System.out.println(a.toString());
		}
	}
	
	public void printFeeAndInterest() 
	{
		
	}

	public void printByAccountType() { }

//	public void printFeeAndInterest() { }
}
