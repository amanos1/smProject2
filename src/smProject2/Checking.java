package smProject2;
import src.Month;
public class Checking extends Account
{
	private final double YEARLY_INTEREST = 0.001;
	private final double FEE = 25;
	private final int FEE_WAIVE = 1000;

	public Checking() { }

	/**
	 * Creates an instance of the Checking class when given just the holder.
	 * @param holder The holder of the account. Should be Profile class.
	 */
	public Checking(Profile holder)
	{
		this.holder = holder;
	}

	/**
	 * Returns the monthly interest.
	 * @return The monthly interest.
	 */
	public double monthlyInterest()
	{
		return this.balance * (YEARLY_INTEREST / Month.TOTAL_MONTHS);
	}
	
	public Profile getHolder()
	{
		return holder;
	}
	
	public void deductFees() 
	{
		if(this.balance > FEE) 
		{
			this.balance -= this.fee();
		}
	}

	/**
	 * Returns the monthly fee.
	 * Returns 0 if the fee is waived.
	 * @return the monthly fee.
	 */
	public double fee()
	{
		if(balance >= FEE_WAIVE) return 0;
		return FEE; //return the monthly fee
	}
	
	//public void deposit(double amount) 
	//{
	//	super.deposit(amount);
	//}
	
	public boolean equals(Object obj) 
	{
		Account newAccount = (Account)obj;
		return (super.equals(obj) && this.getType().equals(newAccount.getType()));
	}
	
	public void deposit(double amount) 
	{
		super.deposit(amount);
	}

	/**
	 * Returns a string containing the type of account.
	 * For use with the AccountDatabase.print method.
	 * @return A string containing the type of account
	 */
	public String getType()
	{
		return "Checking";
	}
}
