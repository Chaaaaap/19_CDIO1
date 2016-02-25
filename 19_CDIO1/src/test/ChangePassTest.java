package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.*;
import data.*;
import interfaces.*;
import interfaces.IOperatorDAO.DALException;
import main.*;

public class ChangePassTest {

	//Variables
	private  OperatorDTO testOperator;
	
	//This is where we set up the test.
	@Before
	public void setUp() throws Exception {
		testOperator = new OperatorDTO("Hans", "Hansen", "123456-7890");
		}
	
	@Test
	public void testChangePassword() throws Exception {
			
		
		String expected = "Test1234";
		String actual = testOperator.getPassword();
		assertEquals(expected, actual);
		
		testOperator.changePassword("Testpass123");
		
		expected = "Testpass123";
		actual = testOperator.getPassword();
		assertEquals(expected, actual);
		}
	
	@Test
	public void testChangePasswordCheck() throws Exception {
			
		String expected = "Test1234";
		String actual = testOperator.getPassword();
		assertEquals(expected, actual);

		try {
			testOperator.changePassword("123456");
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		expected = "Test1234";
		actual = testOperator.getPassword();
		assertEquals(expected, actual);
		}
	
	
}
