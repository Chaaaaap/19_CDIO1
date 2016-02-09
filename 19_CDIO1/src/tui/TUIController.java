package tui;

import java.util.Scanner;

public class TUIController {
	
	Scanner scan;
	
	public TUIController() {
		scan = new Scanner(System.in);
	}
	
	public void createrOperator() {
		System.out.print("Indtast for- og efternavn på den nye operatør");
		String navn = scan.nextLine();
		System.out.print("Indtast CPR-nummer for operatøren");
		String cpr = scan.nextLine();
	}
}
