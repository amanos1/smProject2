package smProject2;
import src.Month;

public class Savings extends Account
{
	private boolean loyal;
	private final double INTEREST = 0.003;
	private final double LOYAL_INTEREST = 0.0045;
	private final double FEE = 6;
	private final int FEE_WAIVE = 300;

	public Savings() { }

	/**
	 * Creates an instance of the Savings class when given the holder and an initial deposit.
	 * @param holder The holder of the account. Should be Profile class.
	 * @param init the initial deposit.
	 */
	public Savings(Profile holder, double init, int loyal)
	{
		this.holder = holder;
		this.balance = init;
		this.loyal = loyal == 1;
	}

	/**
	 * Returns the monthly interest.
	 * @return The monthly interest.
	 */
	public double monthlyInterest()
	{
		if(loyal) return LOYAL_INTEREST / Month.TOTAL_MONTHS;
		return INTEREST / Month.TOTAL_MONTHS;
	}

	/**
	 * Returns the monthly fee.
	 * Returns 0 if the fee is waived.
	 * @return The monthly fee.
	 */
	public double fee()
	{
		if(balance >= FEE_WAIVE) return 0;
		return FEE;
	}

	/**
	 * Returns a string containing the type of account.
	 * For use with the AccountDatabase.print method.
	 * @return A string containing the type of account
	 */
	public String getType()
	{
		return "Savings";
	}
	
	public boolean equals(Object obj) 
	{
		Savings s = (Savings)obj;
		return (super.equals(s) && this.getType().equals(s.getType()));
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
		else if(loyal) acc += "::Loyal";
		return acc;
	}
}
