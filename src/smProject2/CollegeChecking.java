package smProject2;

public class CollegeChecking extends Checking
{
	private int campus;
	private final int NB = 0;
	private final int NEWARK = 1;
	private final int CAMDEN = 2;

	public CollegeChecking(Profile holder, double init, int campus)
	{
		this.holder = holder;
		this.balance = init;
		this.campus = campus;
	}
}
