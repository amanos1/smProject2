package smProject2;

public abstract class Account
{
	protected Profile holder;
	protected boolean closed;
	protected double balance;

	public Account() { }

	/**
	 * Creates an instance of the Account class when given the holder and an initial deposit.
	 * For use with the checking class.
	 * @param holder The holder of the account. Should be Profile class.
	 */
	public Account(Profile holder, int init)
	{
		this.holder = holder;
		this.balance = init;
	}

	@Override
	public boolean equals(Object obj)
	{
		return this.toString().equals(obj);
	}

	@Override
	public String toString()
	{
		return "Account";
	}

	public void withdraw(double amount)
	{
		balance -= amount;
	}

	public void deposit(double amount)
	{
		balance += amount;
	}

	public abstract double monthlyInterest(); //return the monthly interest
	public abstract double fee(); //return the monthly fee
	public abstract String getType(); //return the account type (class name)
}