package smProject2;

public abstract class Account
{
	protected Profile holder;
	protected boolean closed;
	protected double balance;

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