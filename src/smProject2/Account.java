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

	/**
	 * WHAT I WRITE AS A DESCRIPTION FOR THIS FUNCTION DEPENDS ON HOW THIS EQUALS FUNCTION IS USED IN THE PROGRAM
	 */
	@Override
	public boolean equals(Object obj)
	{
		return toString().equals(obj);
	}

	/**
	 * Returns a string representation of the Account
	 * @return a string representation of the Account
	 */
	@Override
	public String toString()
	{
		String acc = getType() + "::" + holder.toString() + "::Balance $" + balance;
		if(closed) acc += "::CLOSED";
		return acc;
	}

	/**
	 * Takes out an amount of money from an account.
	 * @param amount Amount of money to take out.
	 */
	public void withdraw(double amount)
	{
		balance -= amount;
	}

	/**
	 * Adds an amount of money to an account.
	 * @param amount Amount of money to add.
	 */
	public void deposit(double amount)
	{
		balance += amount;
	}

	public abstract double monthlyInterest(); //return the monthly interest
	public abstract double fee(); //return the monthly fee
	public abstract String getType(); //return the account type (class name)
}