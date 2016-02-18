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

	public void createrOperator() throws NullPointerException {
//		try {
		do {
			System.out.println("Indtast det ønskede brugernavn");
			oprNavn = scan.nextLine();
			System.out.println("Indtast fornavn på den nye operatør");
			forNavn = scan.nextLine();
			System.out.println("Indtast efternavn på den nye operatør");
			efterNavn = scan.nextLine();
			System.out.println("Indtast CPR-nummer for operatøren");
			cpr = scan.nextLine();
//			ODTO.createOperator(forNavn, efterNavn, cpr);
//			if(amount > 0) {
//				for(int i = 0; i < ODTO.getOperatorList().size(); i++) {
//					if(ODTO.getOperatorList().get(i).getCPR().equals(cpr))
//						alreadyExist = true;
//				}
//			}
			
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
		
		
//		System.out.println(ODTO.getOperator("123456-1123"));
		//Skal kobles til at create en ny bruger.
//		} catch(Exception e){
//			System.out.println("Der skete en fejl i oprettelsen af brugeren.");
//		}
	}
}

