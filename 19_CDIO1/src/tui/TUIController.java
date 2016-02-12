package tui;

import java.util.Scanner;

public class TUIController {
	
	Scanner scan;
	
	public TUIController() {
		scan = new Scanner(System.in);
	}
	
	public void createrOperator() {
		System.out.println("Indtast fornavn på den nye operatør");
		String forNavn = scan.nextLine();
		System.out.println("Indtast efternavn på den nye operatør");
		String efterNavn = scan.nextLine();
		System.out.println("Indtast CPR-nummer for operatøren");
		String cpr = scan.nextLine();
		
		//Skal kobles til at create en ny bruger.
	}
}
