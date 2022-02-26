package smProject2;

public abstract class Account {
	protected Profile holder;
	protected boolean closed;
	protected double balance;

	/**
	 * This constructor with no arguments will never be run, but I need it to run the program without an error.
	 */
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
		Account newAccount = (Account) obj;
		return holder.isEquals(newAccount.holder) && getType().equals(newAccount.getType());
	}

	/**
	 * Returns a string representation of the Account
	 * @return a string representation of the Account
	 */
	@Override
	public String toString()
	{
		String acc = String.format("%s::%s::Balance $%.2f", getType(), holder, balance);
		if(closed) acc += "::CLOSED";
		return acc;
	}

	/**
	 * Takes out an amount of money from an account.
	 * @param amount Amount of money to take out.
	 */
	public void withdraw(double amount)
	{
		if(balance - amount >= 0) 
		{
			balance -= amount;
		}
	}

	/**
	 * Adds an amount of money to an account.
	 * @param amount Amount of money to add.
	 */
	public void deposit(double amount)
	{
		balance += amount;
	}

	public double getBalance()
	{
		return balance;
	}

	public void close()
	{
		closed = true;
		balance = 0;
	}

	public void unclose()
	{
		closed = false;
	}

	public abstract double monthlyInterest(); //return the monthly interest
	public abstract double fee(); //return the monthly fee
	public abstract String getType(); //return the account type (class name)
}
