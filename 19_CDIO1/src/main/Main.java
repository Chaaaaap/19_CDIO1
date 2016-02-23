package main;

import java.util.Scanner;

import controller.MenuController;
import interfaces.IOperatorDAO.DALException;

public class Main {
	public static void main(String[] args) throws DALException {
		Scanner scan = new Scanner(System.in);
		new MenuController().mainMenu(scan);
	}
}
