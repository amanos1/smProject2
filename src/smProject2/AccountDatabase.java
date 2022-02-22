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

	public void print() { }

	public void printByAccountType() { }

	public void printFeeAndInterest() { }
}
