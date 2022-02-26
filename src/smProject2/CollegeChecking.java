package smProject2;

public class CollegeChecking extends Checking
{
	private int campus;
	private final int NEW_BRUNSWICK = 0;
	private final int NEWARK = 1;
	private final int CAMDEN = 2;
	private final double YEARLY_INTEREST = 0.0025;

	/**
	 * Creates an instance of the CollegeChecking class.
	 * @param holder A Profile representing the owner of the account.
	 * @param init The initial deposit.
	 * @param campusCode The campus code for the account. 0 if New Brunswick, 1 if Newark, and 2 if Camden.
	 */
	public CollegeChecking(Profile holder, double init, int campusCode)
	{
		this.holder = holder;
		this.balance = init;
		this.campus = campus;
	}

	/**
	 * The College Checking account has no monthly fee, so this function will return 0.
	 * @return The monthly fee.
	 */
	@Override
	public double fee()
	{
		return 0;
	}

	/**
	 * Returns the monthly interest.
	 * @return The monthly interest.
	 */
	@Override
	public double monthlyInterest()
	{
		return YEARLY_INTEREST / Month.TOTAL_MONTHS;
	}

	/**
	 * Returns a string containing the type of account.
	 * For use with the Account.toString method.
	 * @return a string containing the type of account
	 */
	@Override
	public String getType()
	{
		return "College Checking";
	}

	/**
	 * Returns the name of the campus the account is registered to.
	 * @return The name of the campus the account is registered to.
	 */
	public String getCampus()
	{
		switch(campus)
		{
			case NEW_BRUNSWICK: return "NEW_BRUNSWICK";
			case CAMDEN: return "CAMDEN";
			case NEWARK: return "NEWARK";
			default: return "";
		}
	}
	
	public boolean equals(Object obj) 
	{
		CollegeChecking newAccount = (CollegeChecking)obj;
		return (super.equals(newAccount) && this.getCampus().equals(newAccount.getCampus()));
	}
	
	/**
	 * Returns a string representation of the Account
	 * @return a string representation of the Account
	 */
	@Override
	public String toString()
	{
		String acc = super.toString();
		acc += "::" + getCampus();
		return acc;
	}
}
