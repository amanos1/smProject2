package smProject2;

public class AccountDatabase
{
	private Account [] accounts;
	private int numAcct;

	private int find(Account account)
	{
		return 0;
	}

	private void grow() { }

	public boolean open(Account account)
	{
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

	public void printByAccountType() { }

	public void printFeeAndInterest() { }
}
