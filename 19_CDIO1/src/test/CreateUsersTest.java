package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import controller.*;
import data.*;
import interfaces.*;
import interfaces.IOperatorDAO.DALException;
import main.*;

public class CreateUsersTest {

	//Variables
	private OperatorDAO oC;
	private OperatorDAO oCont;
	private OperatorDTO testOperator;

	//This is where we set up the test.
	@Before
	public void setUp() throws Exception {

		oCont = new OperatorDAO();
	}

	@Test
	public void CreateUserTest() throws Exception {
		int expected = 4;
		int actual = oCont.getOperatoerList().size();
		assertEquals(expected, actual);

		testOperator = new OperatorDTO("Hans", "Hansen", "123456-7890");

		oCont.createOperatoer(testOperator);

		for (int i = 0; i < oCont.getOperatoerList().size(); i++) {
			System.out.println(oCont.getOperatoerList().get(i));
		}
		
		expected = 5;
		actual = oCont.getOperatoerList().size();
		assertEquals(expected, actual);
	}

	@Test
	public void MaxAmountOfUsersTest() throws Exception {
		int expected = 4;
		int actual = oCont.getOperatoerList().size();
		assertEquals(expected, actual);
		int nr = 10;

		OperatorDTO[] oArray = new OperatorDTO[89];
		
		for (int i = 0; i < 82; i++) {
			String cpr = "";
			cpr += nr;
			try {
				oArray[i] = new OperatorDTO("hej", "dig", cpr+"0000-0000");
				oCont.createOperatoer(oArray[i]);	
				nr++;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

	}
		

	expected = 85;
	
	actual = oCont.getOperatoerList().size();
	assertEquals(expected, actual);
	}	
}	

