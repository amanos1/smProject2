package smProject2;

import java.util.Scanner;
import java.util.StringTokenizer;

import src.Date;
import src.Patient;
import src.Time;

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
	 * Opens a new account with the information in the given string.
	 * Prints error message if the command is invalid or the account conflicts with another one.
	 * @param com The input string containing information about the account to be created.
	 */
	private void open(String com)
	{
	    StringTokenizer st = new StringTokenizer(com," ");
	    st.nextToken();
	    String type = st.nextToken();
	    String fname = st.nextToken();
	    String lname = st.nextToken();
	    String dob = st.nextToken();
	    Profile profile = new Profile(fname, lname, dob);
	    
	    Account account;
	    switch(type)
	    {
		    case "C":
		    	account = new Checking(profile);
		    	break;
		    case "CC":
		    	double init = Double.parseDouble(st.nextToken());
		    	int campus = Integer.parseInt(st.nextToken());
		    	account = new CollegeChecking(profile, init, campus);
		    	break;
		    case "S":
		    	double initDeposit = Double.parseDouble(st.nextToken());
		    	int loyal = Integer.parseInt(st.nextToken());
		    	account = new Savings(profile, initDeposit, loyal);
		    	break;
		    case "MM":
		    	double init = Double.parseDouble(st.nextToken());
		    	account = new MoneyMarket(profile, init);
		    	break;
	    }

	    Date appointmentDate = new Date(st.nextToken());
		return;
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
