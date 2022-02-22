package smProject2;

public class Profile
{
	private String fname;
	private String lname;
	private Date dob;

    /**
	 * Creates an instance of the Profile class given patient first name, last name and date of birth.
	 * @param fname String first name.
	 * @param lname String last name.
	 * @param date Date of birth.
	 */
	public Profile(String fname, String lname, String dob)
	{
		this.fname = fname;
		this.lname = lname;
		this.dob = new Date(dob);
	}

	/**
	 * Returns a string representation of the profile
	 * @return a string representation of the profile
	 */
	@Override
	public String toString()
	{
		return fname + " " + lname + " " + dob.toString();
	}
}
