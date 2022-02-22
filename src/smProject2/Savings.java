package smProject2;

public class Savings extends Account
{
	public Savings() { }

	/**
	 * Creates an instance of the Account class when given the holder and an initial deposit.
	 * For use with the checking class.
	 * @param holder The holder of the account. Should be Profile class.
	 */
	public Savings(Profile holder, int init)
	{
		this.holder = holder;
		this.balance = init;
	}

	public double monthlyInterest()
	{
		return 8; //return the monthly interest
	}

	public double fee()
	{
		return 15; //return the monthly fee
	}

	public String getType() {
		return "Savings"; //return the account type (class name)
	}
}
