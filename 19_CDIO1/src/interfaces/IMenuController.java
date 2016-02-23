package interfaces;

import java.util.Scanner;

import interfaces.IOperatorDAO.DALException;

public interface IMenuController {

	void mainMenu(Scanner scan) throws DALException;
	void createUser(Scanner scan) throws DALException;
	void changePassword(Scanner scan) throws DALException;
	boolean oprLogin(Scanner scan) throws DALException;
	void balancing(Scanner scan) throws DALException;
	double afvejning(Scanner scan) throws DALException;
}
