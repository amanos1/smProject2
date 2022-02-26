package smProject2;

public class MoneyMarket extends Savings
{
	public boolean loyal;
	private int withdrawls;

	private static final double YEARLY_INTEREST = 0.008;
	private static final double LOYAL_INTEREST = 0.0095;
	private static final double FEE = 10;
	private static final int LOYAL_MIN = 2500;

	/**
	 * Creates an instance of the MoneyMarket class when given the holder and initial deposit.
	 * @param holder The holder of the account. Should be Profile class.
	 * @param init The initial deposit.
	 */
	public MoneyMarket(Profile holder, double init)
	{
		this.holder = holder;
		this.balance = init;
		this.loyal = true;
		this.withdrawls = 0;
	}

	/**
	 * Withdraws money from an account, but sets the account to not loyal if balance goes below $2500.
	 */
	@Override
	public void withdraw(double amount)
	{
		super.withdraw(amount);
		if(balance < LOYAL_MIN) loyal = false;
		withdrawls++;
		
	}

	/**
	 * Returns the monthly interest.
	 * @return The monthly interest.
	 */
	@Override
	public double monthlyInterest()
	{
		if(loyal) return LOYAL_INTEREST / Month.TOTAL_MONTHS;
		return YEARLY_INTEREST / Month.TOTAL_MONTHS;
	}

	/**
	 * Returns the monthly fee.
	 * Returns 0 if the fee is waived.
	 * @return The monthly fee.
	 */
	@Override
	public double fee()
	{
		if(balance >= LOYAL_MIN) return 0;
		return FEE;
	}

	/**
	 * Returns a string containing the type of account.
	 * For use with the AccountDatabase.print method.
	 * @return A string containing the type of account
	 */
	@Override
	public String getType()
	{
		return "Money Market Savings";
	}
	
	/**
	 * Returns a string representation of the Account
	 * @return a string representation of the Account
	 */
	@Override
	public String toString()
	{
		String acc = super.toString();
		acc += "::withdrawl: " + withdrawls;
		return acc;
	}
}
