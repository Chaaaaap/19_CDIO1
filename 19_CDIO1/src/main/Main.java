package main;

import controller.MenuController;
import interfaces.IOperatorDAO.DALException;

public class Main {
	public static void main(String[] args) throws DALException {
		new MenuController();
	}
}
