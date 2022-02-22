package smProject2;

public class Checking extends Account
{
	public double monthlyInterest()
	{
		return 5; //return the monthly interest
	}
	public double fee()
	{
		return 5;//return the monthly fee
	}

	public String getType()
	{
		return "Checking."; //return the account type (class name)
	}
}
