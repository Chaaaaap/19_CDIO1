package tui;

import java.util.Scanner;

import data.OperatorDTO;

public class TUIController {

	private Scanner scan;
	boolean fejl;
	private OperatorDTO ODTO;
	private boolean alreadyExist;
	private String forNavn;
	private String efterNavn;
	private String cpr;
	private String oprNavn;

	public TUIController() {
		scan = new Scanner(System.in);
		ODTO = new OperatorDTO();
	}

	public void createrOperator(Scanner scan) {
		do {
			System.out.println("Indtast fornavn på den nye operatør");
			forNavn = scan.nextLine();
			System.out.println("Indtast efternavn på den nye operatør");
			efterNavn = scan.nextLine();
			System.out.println("Indtast CPR-nummer for operatøren");
			cpr = scan.nextLine();
			
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
		
	}
}

