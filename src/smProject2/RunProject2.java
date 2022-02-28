package smProject2;

/**
 * Driver class that initiates the program.
 * @author Aaron Browne
 */
public class RunProject2
{

	/**
	 * This function kicks off the program by calling Kiosk's run() function.
	 * @param args The command-line arguments
	 */
	public static void main(String[] args)
	{
		new BankTeller().run();
	}
}
