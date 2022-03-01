package smProject2;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is a test class that checks the isValid() method of the Data class
 * using assert statements.
 * @author Harshkumar Patel, Aaron Browne
 *
 */
class DateTest {

	@org.junit.Test
	void test() {
		Date d;
		
		//test case 1
		d = new Date("5/22/1883");
		assertFalse(d.isValid());
		
		//test case 2
		d = new Date("16/3/1984");
		assertFalse(d.isValid());
		
		//test case 3
		d = new Date("0/15/2002");
		assertFalse(d.isValid());
		
		//test case 4
		d = new Date("2/29/1993");
		assertFalse(d.isValid());
		
		//test case 5
		d = new Date("2/-1/1993");
		assertFalse(d.isValid());
		
		//test case 6
		d = new Date("2/31/1984");
		assertFalse(d.isValid());
		
		//test case 7
		d = new Date("6/31/2000");
		assertFalse(d.isValid());
		
		//test case 8
		d = new Date("6/0/2000");
		assertFalse(d.isValid());
		
		//test case 9
		d = new Date("12/500/1994");
		assertFalse(d.isValid());
		
		//test case 10
		d = new Date("12/0/1994");
		assertFalse(d.isValid());
		
		//test case 11
		d = new Date("3/3/2019");
		assertTrue(d.isValid());
		
	}

}
