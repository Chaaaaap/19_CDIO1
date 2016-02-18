package tui;

import java.util.Scanner;

import data.OperatorDTO;

public class TUIRun {

	private TUIController cont = new TUIController();
	private Scanner scan = new Scanner(System.in);	
	private int choice;
	private boolean loop = true;
	private OperatorDTO odto;
	
	public TUIRun() {
		mainMenu(scan);
		odto = new OperatorDTO();
	}

	public void mainMenu(Scanner scan){
		System.out.println("Velkommen til 'applikation-navn'!\n");
		
		do{
			System.out.println("Du har nu følgende valgmuligheder:\n"
					+ "1. Opret ny bruger.\n"
					+ "2. Skift password.\n"
					+ "3. Afvejning.\n"
					+ "4. Afslut.\n"
					+ "Indtast et nummer mellem 1-4:");
			choice = scan.nextInt();

			if(choice == 1){
				createUser(scan);
			}
			else if(choice == 2){
				changePassword(scan);
			}
			else if(choice == 3){
				balancing(scan);
			}
			else if(choice == 4){
				exit(scan);
				System.out.println("Du har afsluttet applikation. På gensyn.");
			}
			else{
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
			}
		}
		while(loop);
		scan.close();
	}

	private void exit(Scanner scan) {
		loop = false;
	}

	public void createUser(Scanner scan){
		System.out.println("Du har nu følgende valgmuligheder:\n"
				+ "1. Opret ny bruger.\n"
				+ "2. Gå tilbage.\n"
				+ "Indtast et nummer mellem 1-2:");
		do{
			choice = scan.nextInt();

			if(choice == 1){
				if(loginSysAdmin()) {
					cont.createrOperator();
					
				}
			}
			else if(choice == 2){
				mainMenu(scan);
			}
			else{
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
			}

		}
		while(choice > 2);
	}

	public void changePassword(Scanner scan){
		System.out.println("Du har nu følgende valgmuligheder:\n"
				+ "1. Skift password.\n"
				+ "2. Gå tilbage.\n"
				+ "Indtast et nummer mellem 1-2:");
		do{
			choice = scan.nextInt();

			if(choice == 1){
				System.out.println("Skift password.");
				skiftKode(scan);
			}
			else if(choice == 2){
				mainMenu(scan);
			}
			else{
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
			}
		}
		while(choice > 2);
	}

	private void skiftKode(Scanner scan) {
		oprLogin(scan);
		System.out.println("Indtast din nye adgangskode");
		String newpass = scan.nextLine();
		System.out.println("Gentag din nye adgangskode");
		String newpass2 = scan.nextLine();
		
	}

	public void balancing(Scanner scan){
		System.out.println("Afvejning er kun tilladt for oprettede brugere.\nDu har nu følgende valgmuligheder:\n"
				+ "1. Login.\n"
				+ "2. Gå tilbage.\n"
				+ "Indtast et nummer mellem 1-2:");
		do{
			choice = scan.nextInt();

			if(choice == 1){
				if (oprLogin(scan)) {
					System.out.println(afvejning(scan));
				}
			}
			else if(choice == 2){
				mainMenu(scan);
			}
			else{
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
			}
		}
		while(choice > 2);
	}
	
	public boolean oprLogin(Scanner scan) {
		String password;
		int oprId;
		
		System.out.println("Bruger nr.:");
		oprId = scan.nextInt();
		System.out.println("Password:");
		password = scan.next();
		
		for(int i = 0; i < odto.getOperatorList().size(); i++)
			if(odto.getOperatorList().get(i).getOprId() == oprId)
				if(odto.getOperatorList().get(i).getPassword(oprId).equals(password))
					return true;
		
		return false;
		
	}
	
	public double afvejning(Scanner scan) {
		
		System.out.println("Afvejning.\n");
		System.out.println("Indtast emballage vægt i kg.");
		double emballage = scan.nextDouble();
		System.out.println("Indtast bruttovægt i kg.");
		double brutto = scan.nextDouble();
		
		double netto = brutto - emballage;
		
		return netto;
		
	}

	public boolean loginSysAdmin(){
		Scanner scan = new Scanner(System.in);
		int oprId;
		String password;
		System.out.println("Login som sysadmin.");

		System.out.println("Bruger nr.:");
		oprId = scan.nextInt();
		System.out.println("Password:");
		password = scan.next();

		if(sysAdminOprId() == oprId && password.equals(sysAdminPassword())){
			return true;
		}
		else{
			System.out.println("Forkert bruger nr. eller password. Du bliver ført tilbage til foregående menu. \n");
			createUser(scan);
			return false;
		}
	}

	public int sysAdminOprId(){
		int oprId = 10;
		return oprId;
	}

	public String sysAdminPassword(){
		String password = "Abc02324";
		return password;
	}

}