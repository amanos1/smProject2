package smProject2;

public class Checking extends Account
{
	public Checking() { }

	/**
	 * Creates an instance of the Account class when given just the holder.
	 * For use with the checking class.
	 * @param holder The holder of the account. Should be Profile class.
	 */
	public Checking(Profile holder)
	{
		this.holder = holder;
	}

	public double monthlyInterest()
	{
		return 5; //return the monthly interest
	}

	public double fee()
	{
		return 5; //return the monthly fee
	}

	public String getType()
	{
		return "Checking."; //return the account type (class name)
	}
}
