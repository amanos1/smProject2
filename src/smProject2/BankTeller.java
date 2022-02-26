package smProject2;
import src.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BankTeller
{
	private AccountDatabase database;
	private static final int MONEY_MARKET_MIN = 2500;
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

	        if(commandList[0].equals("Q")) break;
	        switch(commandList[0])
	        {
		        case "O":
		        	open(command);
		            break;
		        case "C":
		        	close(command);
		            break;
		        case "D":
		            deposit(command);
		            break;
		        case "W":
		            withdraw(command);
		            break;
		        case "P":
		        	database.print();
		            break;
		        case "PT":
		        	database.printByAccountType();
		            break;
		        case "PI":
		        	database.printFeeAndInterest();
		            break;
		        case "UB":
		        	update();
		            break;
		        default:
		        	System.out.println("Invalid command!");
	        }
	    }

	    scn.close();
	    System.out.println("Bank Teller is terminated.");	    
	}
	
	
	/**
	 * Creates a Profile object with the information provided.
	 * @param input The input string containing information about the Profile.
	 * @param st The StringTokenizer we use to parse the input string. 
	 * @param open Boolean for whether the Profile is being used for opening or closing an account.
	 * @return The resulting profile or null if the data in the input string would result in an invalid profile.
	 */
	private Profile createProfile(String input, StringTokenizer st, boolean open)
	{
	    if(!st.hasMoreTokens()) {
	    	if (open) System.out.println("Missing data for opening an account.");
	    	else      System.out.println("Missing data for closing an account.");
	    	return null;
	    }
	    String fname = st.nextToken();

	    if(!st.hasMoreTokens()) {
	    	if (open) System.out.println("Missing data for opening an account.");
	    	else      System.out.println("Missing data for closing an account.");
	    	return null;
	    }
	    String lname = st.nextToken();

	    if(!st.hasMoreTokens()) {
	    	if (open) System.out.println("Missing data for opening an account.");
	    	else      System.out.println("Missing data for closing an account.");
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
	

	

	/**
	 * Creates an Account object with the info provided.
	 * @param input The string containing information about the account to open.
	 * @param type The type of account in string form.
	 * @param profile The holder of the account as a Profile object.
	 * @param st The StringTokenizer we use to parse the input string.
	 * @return The resulting account or null if the data in the input string would result in an invalid account.
	 */
	private Account createAccount(String input, String type, Profile profile, StringTokenizer st)
	{
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
			    } else if (init < MONEY_MARKET_MIN)
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


	    Profile profile = createProfile(com, st, true);
	    if(profile == null) return;

	    Account account = createAccount(com, type, profile, st);
	    if(account == null) return;

	    if(!database.open(account))
	    {
	    	System.out.println(profile + " same account(type) is in the database.");
	    } else
	    {
	    	System.out.println("Account opened.");
	    }
	}

	/**
	 * Closes an account with the information in the given string.
	 * Prints an error message if the command is invalid or the account cannot be closed.
	 * @param com The input string containing information about the account to be closed.
	 */
	private void close(String com)
	{
	    StringTokenizer st = new StringTokenizer(com, " ");
	    st.nextToken();
	    if(!st.hasMoreTokens())
	    {
	    	System.out.println("Invalid Command!");
	    	return;
	    }

	    String type = st.nextToken();

	    Profile profile = createProfile(com, st, false);
	    if(profile == null) return;

	    Account closeIt;
	    if(type.equals("C"))       closeIt = new Checking(profile);
	    else if(type.equals("CC")) closeIt = new CollegeChecking(profile, 1, 0);
	    else if(type.equals("S"))  closeIt = new Savings(profile, 1, true);
	    else                       closeIt = new MoneyMarket(profile, MONEY_MARKET_MIN);

	    if(!database.isThere(closeIt))
	    {
	    	System.out.println("Account cannot be closed because it does not exist.");
	    	return;
	    }

	    if(!database.close(closeIt))
	    {
	    	System.out.println("Account is closed already.");
	    }
	}



	private void update()
	{
		database.update();
	}

	private void deposit(String com)
	{
		StringTokenizer st = new StringTokenizer(com, " ");
	    st.nextToken();
	    if(!st.hasMoreTokens())
	    {
	    	System.out.println("Invalid Command!");
	    	return;
	    }

	    String type = st.nextToken();


	    Profile profile = createProfile(com, st, true);
	    if(profile == null) return;
	    if(!st.hasMoreTokens())
	    {
	    	System.out.println("Invalid Command!");
	    	return;
	    }
	    double depositAmount = Double.parseDouble(st.nextToken());
	    int profileIndex = database.findHolder(profile);
	    //System.out.println(profile+" "+profileIndex);
	    if(profileIndex != -1) 
	    {
	    	database.depositAmount(profileIndex, depositAmount);
	    }else 
	    {
	    	System.out.println("Account does not exists");
	    }
	    
	    
		return;
	}

	private void withdraw(String com)
	{
		StringTokenizer st = new StringTokenizer(com, " ");
	    st.nextToken();
	    if(!st.hasMoreTokens())
	    {
	    	System.out.println("Invalid Command!");
	    	return;
	    }

	    String type = st.nextToken();


	    Profile profile = createProfile(com, st, true);
	    if(profile == null) return;
	    if(!st.hasMoreTokens())
	    {
	    	System.out.println("Invalid Command!");
	    	return;
	    }
	    double withdrawAmount = Double.parseDouble(st.nextToken());
	    int profileIndex = database.findHolder(profile);
	    //System.out.println(profile+" "+profileIndex);
	    if(profileIndex != -1) 
	    {
	    	if(!(database.withdrawAmount(profileIndex, withdrawAmount))) 
	    	{
	    		System.out.println("Insufficient Balance");
	    	}
	    }else 
	    {
	    	System.out.println("Account does not exists");
	    }
		//System.out.println(withdrawAmount);
	}

	
}
