package tui;

import java.util.Scanner;

public class TUIRun {

	TUIController cont = new TUIController();
	//	Scanner scan;
	int choice;

	public void mainMenu(){
		Scanner scan = new Scanner(System.in);
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
				createUser();
				//				scan.close();
			}
			else if(choice == 2){
				changePassword();
				//				scan.close();
			}
			else if(choice == 3){
				balancing();
				//				scan.close();
			}
			else if(choice == 4){
				System.out.println("Du har afsluttet applikation. På gensyn.");
				//				scan.close();
			}
			else{
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
				//				scan.close();
			}
		}
		while(choice > 4);
		//		scan.close();
	}

	public void createUser(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Du har nu følgende valgmuligheder:\n"
				+ "1. Opret ny bruger.\n"
				+ "2. Gå tilbage.\n"
				+ "Indtast et nummer mellem 1-2:");
		do{
			choice = scan.nextInt();

			if(choice == 1){
				loginSysAdmin();
				//				scan.close();
			}
			else if(choice == 2){
				mainMenu();
				//				scan.close();
			}
			else{
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
				//				scan.close();
			}

		}
		while(choice > 2);
		//		scan.close();
	}

	public void changePassword(){
		Scanner scan = new Scanner(System.in);
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
				mainMenu();
				//				scan.close();
			}
			else{
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
				//				scan.close();
			}
		}
		while(choice > 2);
		//		scan.close();
	}

	public void balancing(){
		Scanner scan = new Scanner(System.in);
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
				mainMenu();
				//				scan.close();
			}
			else{
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
				//				scan.close();
			}
		}
		while(choice > 2);
		//		scan.close();
	}

	public void loginSysAdmin(){
		Scanner scan = new Scanner(System.in);
		int oprId;
		String password;
		System.out.println("Login som sysadmin.");

		System.out.println("Bruger nr.:");
		oprId = scan.nextInt();
		System.out.println("Password:");
		password = scan.next();

		if(sysAdminOprId() == oprId && password.equals(sysAdminPassword())){
			cont.createrOperator();
			//				scan.close();
		}
		else{
			System.out.println("Forkert bruger nr. eller password. Du bliver først tilbage til menuen før. \n");
			createUser();
			//				scan.close();
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