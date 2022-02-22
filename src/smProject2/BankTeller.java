package smProject2;

import java.util.Scanner;

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

	private void open(String com)
	{
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
