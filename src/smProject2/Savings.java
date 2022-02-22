package smProject2;

public class Savings extends Account
{
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
