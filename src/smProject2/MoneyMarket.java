package smProject2;
import src.Month;

public class MoneyMarket extends Savings
{
	public boolean loyal;
	private int withdrawls;
	private final double YEARLY_INTEREST = 0.008;
	private final double LOYAL_INTEREST = 0.0095;
	private final double FEE = 10;
	private final int FEE_WAIVE = 2500;
	private static final int TOTAL_ALLOWED_WITHDRAWALS = 3;

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

	@Override
	public void withdraw(double amount)
	{
		super.withdraw(amount);
		if(balance < 2500) loyal = false;
		withdrawls++;
		
	}
	
	public void deductWithdrawls() 
	{
		this.withdrawls--;
	}

	/**
	 * Returns the monthly interest.
	 * @return The monthly interest.
	 */
	@Override
	public double monthlyInterest()
	{
		if(loyal) return this.balance * (LOYAL_INTEREST / Month.TOTAL_MONTHS);
		return this.balance * (YEARLY_INTEREST / Month.TOTAL_MONTHS);
	}

	/**
	 * Returns the monthly fee.
	 * Returns 0 if the fee is waived.
	 * @return The monthly fee.
	 */
	@Override
	public double fee()
	{
		if(balance >= FEE_WAIVE && this.withdrawls <= TOTAL_ALLOWED_WITHDRAWALS) return 0;
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
	
	public boolean equals(Object obj) 
	{
		MoneyMarket mm = (MoneyMarket)obj;
		return (super.equals(mm));
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
		acc += "::withdrawl: " + withdrawls;
		return acc;
	}
}
