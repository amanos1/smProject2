package smProject2;

public class MoneyMarket extends Savings
{
	public boolean loyal;

	/**
	 * Creates an instance of the Account class when given the holder, initial deposit, and whether or the the customer is loyal.
	 * For use with the checking class.
	 * @param holder The holder of the account. Should be Profile class.
	 */
	public Account(Profile holder, double init, int loyal)
	{
		this.holder = holder;
		this.balance = init;
		this.loyal = loyal == 1;
	}
}
