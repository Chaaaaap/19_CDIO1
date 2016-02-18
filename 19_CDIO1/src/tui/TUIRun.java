package tui;

import java.util.Scanner;

public class TUIRun {

	private TUIController cont = new TUIController();
	private Scanner scan = new Scanner(System.in);	
	private int choice;
	private boolean loop = true;
	
	public TUIRun() {
		mainMenu(scan);
	}

	public void mainMenu(Scanner scan){
		System.out.println("Velkommen til 'applikation-navn'!\n");
		System.out.println("Du har nu følgende valgmuligheder:\n"
				+ "1. Opret ny bruger.\n"
				+ "2. Skift password.\n"
				+ "3. Afvejning.\n"
				+ "4. Afslut.\n"
				+ "Indtast et nummer mellem 1-4:");
		do{
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
				if(loginSysAdmin())
					cont.createrOperator();
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

	public void balancing(Scanner scan){
		System.out.println("Du har nu følgende valgmuligheder:\n"
				+ "1. Foretag afvejning.\n"
				+ "2. Gå tilbage.\n"
				+ "Indtast et nummer mellem 1-2:");
		do{
			choice = scan.nextInt();

			if(choice == 1){
				System.out.println("Afvejning.");
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
			System.out.println("Forkert bruger nr. eller password. Du bliver først tilbage til menuen før. \n");
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