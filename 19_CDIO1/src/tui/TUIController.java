package tui;

import java.util.Scanner;

import data.OperatorDTO;

public class TUIController {

	Scanner scan;
	boolean fejl;
	private OperatorDTO ODTO;
	private boolean alreadyExist;

	public TUIController() {
		scan = new Scanner(System.in);
		ODTO = new OperatorDTO();
	}

	public void createrOperator() throws NullPointerException {
		try {
		do {
			System.out.println("Indtast fornavn på den nye operatør");
			String forNavn = scan.nextLine();
			System.out.println("Indtast efternavn på den nye operatør");
			String efterNavn = scan.nextLine();
			System.out.println("Indtast CPR-nummer for operatøren");
			String cpr = scan.nextLine();

			for(int i = 0; i < ODTO.getOperatorList().size(); i++) {
				if(ODTO.getOperatorList().get(i).getCPR().equals(cpr))
					alreadyExist = true;
			}
					if(cpr.length() < 11) {
						System.out.println("Fejl! Det indtastede CPR-nummer er ikke gyldigt. Det skal indtastes ddmmåå-xxxx");
						fejl = true;
					} else if(alreadyExist) {
						System.out.println("Fejl! Det indtastede CPR-nummer er allerede tilknyttet en bruger!");
						fejl = true;
					} else {
						fejl = false;
					} 
		}while(fejl);

		//Skal kobles til at create en ny bruger.
		} catch(Exception e){
			System.out.println("Der skete en fejl i oprettelsen af brugeren.");
		}
	}
}

