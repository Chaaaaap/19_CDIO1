package tui;

import java.util.Scanner;

import data.OperatorDTO;
import interfaces.IMenuController;
import interfaces.IOperatorDAO.DALException;

public class TUIController {

	private boolean alreadyExist;
	private String forNavn;
	private String efterNavn;
	private String cpr;

	public TUIController() {
	}

	public OperatorDTO createrOperator(Scanner scan) throws DALException {

		System.out.println("Indtast fornavn på den nye operatør");
		forNavn = scan.next();
		System.out.println("Indtast efternavn på den nye operatør");
		efterNavn = scan.next();
		System.out.println("Indtast CPR-nummer for operatøren");
		cpr = scan.next();

		if(cpr.length() < 11 || cpr.length() > 12) {
			throw new DALException("Fejl! Det indtastede CPR-nummer er ikke gyldigt. Det skal indtastes ddmmåå-xxxx");
		} else if(alreadyExist) {
			throw new DALException("Fejl! Det indtastede CPR-nummer er allerede tilknyttet en bruger!");
		}

		OperatorDTO operator = new OperatorDTO(forNavn, efterNavn, cpr);

		return operator;
	}
}

