package smProject2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BankTeller
{
	private AccountDatabase database;

	/**
     * This function serves as the backbone of the program.
     * It reads lines of input and either calls a function accordingly or prints "Invalid Command!"
     */
	public void run()
	{
		database = new AccountDatabase();
	    String command;
	    String[] commandList;
	    Scanner scn = new Scanner(System.in);

	    System.out.println("Bank Teller is running.");

	    while(scn.hasNextLine())
	    {
	        command = scn.nextLine();
	        commandList = command.split(" ");

	        String c = commandList[0];
	        if(c.equals("Q")) break;
	        else if(c.equals("O")) open(command);
	        else if(c.equals("C")) close(command);
	        else if(c.equals("D")) deposit(command);
	        else if(c.equals("W")) withdraw(command);
	        else if(c.equals("P")) database.print();
	        else if(c.equals("PT")) database.printByAccountType();
	        else if(c.equals("PI")) database.printFeeAndInterest();
	        else if(c.equals("UB")) update();
	        else System.out.println("Invalid command!");
	    }

	    scn.close();
	    System.out.println("Bank Teller is terminated.");	    
	}

	private Profile createProfile(String input)
	{
	    StringTokenizer st = new StringTokenizer(input, " ");
	    st.nextToken();
	    st.nextToken();
	    if(!st.hasMoreTokens()) {
	    	System.out.println("Missing data for opening an account.");
	    	return null;
	    }
	    String fname = st.nextToken();

	    if(!st.hasMoreTokens()) {
	    	System.out.println("Missing data for opening an account.");
	    	return null;
	    }
	    String lname = st.nextToken();

	    if(!st.hasMoreTokens()) {
	    	System.out.println("Missing data for opening an account.");
	    	return null;
	    }

	    String dob = st.nextToken();
	    Date birth = new Date(dob);

	    if(!birth.isValid())
	    {
	    	System.out.println("Date of birth invalid.");
	    }

	    Profile p = new Profile(fname, lname, dob);
		return p;
	}

	private Account createAccount(String input, String type, Profile profile)
	{
	    StringTokenizer st = new StringTokenizer(input, " ");
	    st.nextToken();
	    st.nextToken();
	    st.nextToken();
	    st.nextToken();
	    st.nextToken();

	    Account a;
	    double init;

	    switch(type)
	    {
		    case "C":
		    	a = new Checking(profile);
		    	break;

		    case "CC":
			    if(!st.hasMoreTokens())
			    {
			    	System.out.println("Missing data for opening an account.");
			    	return null;
			    }

			    try
			    {
			    	init = Double.parseDouble(st.nextToken());
			    } catch (NumberFormatException e)
			    {
			    	System.out.println("Not a valid amount.");
			    	return null;
			    }

			    if(!st.hasMoreTokens())
			    {
			    	System.out.println("Missing data for opening an account.");
			    	return null;
			    }

			    int campus;
			    try
			    {
			    	campus = Integer.parseInt(st.nextToken());
			    } catch(NumberFormatException e)
			    {
			    	System.out.println("Not a valid amount.");
			    	return null;
			    }

			    if(init <= 0)
			    {
			    	System.out.println("Initial deposit cannot be 0 or negative.");
			    	return null;
			    }

			    if(campus > 2 || campus < 0)
			    {
			    	System.out.println("Invalid campus code.");
			    }

			    a = new CollegeChecking(profile, init, campus);
		    	break;

		    case "S":
			    if(!st.hasMoreTokens())
			    {
			    	System.out.println("Missing data for opening an account.");
			    	return null;
			    }

			    try
			    {
			    	init = Double.parseDouble(st.nextToken());
			    } catch (NumberFormatException e)
			    {
			    	System.out.println("Not a valid amount.");
			    	return null;
			    }
			    if(!st.hasMoreTokens())
			    {
			    	System.out.println("Missing data for opening an account.");
			    	return null;
			    }
		    	String loyal = st.nextToken();

		    	if(init <= 0)
			    {
			    	System.out.println("Initial deposit cannot be 0 or negative.");
			    	return null;
			    }

		    	a = new Savings(profile, init, loyal.equals("1"));
		    	break;

		    case "MM":
			    if(!st.hasMoreTokens())
			    {
			    	System.out.println("Missing data for opening an account.");
			    	return null;
			    }

			    try
			    {
			    	init = Double.parseDouble(st.nextToken());
			    } catch(NumberFormatException e)
			    {
			    	System.out.println("Not a valid amount.");
			    	return null;
			    }

		    	if(init <= 0)
			    {
			    	System.out.println("Initial deposit cannot be 0 or negative.");
			    	return null;
			    } else if (init < 2500)
			    {
			    	System.out.println("Minimum of $2500 to open a MoneyMarket account.");
			    }

			    a = new MoneyMarket(profile, init);
		    	break;

		    default:
	    		a = null;
	    }
	    return a;
	}

	/**
	 * Opens a new account with the information in the given string.
	 * Prints error message if the command is invalid or the account conflicts with another one.
	 * @param com The input string containing information about the account to be created.
	 */
	private void open(String com)
	{
	    StringTokenizer st = new StringTokenizer(com, " ");
	    st.nextToken();
	    if(!st.hasMoreTokens())
	    {
	    	System.out.println("Invalid Command!");
	    	return;
	    }

	    String type = st.nextToken();


	    Profile profile = createProfile(com);
	    if(profile == null) return;

	    Account account = createAccount(com, type, profile);
	    if(account == null) return;

	    if(!database.open(account))
	    {
	    	System.out.println(profile + " same account(type) is in the database.");
	    } else
	    {
	    	System.out.println("Account opened.");
	    }
	}

	private void close(String com)
	{
		return;
	}

	private void deposit(String com)
	{
		return;
	}

	private void withdraw(String com)
	{
		return;
	}

	private void update()
	{
		return;
	}
}
