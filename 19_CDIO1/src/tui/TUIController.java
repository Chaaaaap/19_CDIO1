package tui;

import java.util.Scanner;

import data.OperatorDTO;

public class TUIController {

	boolean fejl;
	private boolean alreadyExist;
	private String forNavn;
	private String efterNavn;
	private String cpr;

	public TUIController() {
	}

	public OperatorDTO createrOperator(Scanner scan) {
		do {
			System.out.println("Indtast fornavn på den nye operatør");
			forNavn = scan.next();
			System.out.println("Indtast efternavn på den nye operatør");
			efterNavn = scan.next();
			System.out.println("Indtast CPR-nummer for operatøren");
			cpr = scan.next();
			
					if(cpr.length() < 11 || cpr.length() > 12) {
						System.out.println("Fejl! Det indtastede CPR-nummer er ikke gyldigt. Det skal indtastes ddmmåå-xxxx");
						fejl = true;
					} else if(alreadyExist) {
						System.out.println("Fejl! Det indtastede CPR-nummer er allerede tilknyttet en bruger!");
						fejl = true;
					} else {
						fejl = false;
					} 
		}while(fejl);
		OperatorDTO operator = new OperatorDTO(forNavn, efterNavn, cpr);
		
		return operator;
	}
}

