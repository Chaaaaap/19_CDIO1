package controller;

import java.util.Scanner;
import interfaces.IMenuController;
import interfaces.IOperatorDAO.DALException;
import tui.TUIController;

public class MenuController implements IMenuController {

	private TUIController tCont;
	private Scanner scan;	
	private int choice;
	private int userId;
	private boolean loop = true;
	private OperatorDAO oCont;

	public MenuController() throws DALException {
		tCont = new TUIController();
		scan =  new Scanner(System.in);
		oCont = new OperatorDAO();
	}

	public void mainMenu(Scanner scan) throws DALException{
		System.out.println("Velkommen til Afvejningssystemet!\n");

		do{
			System.out.println("Du har nu følgende valgmuligheder:\n"
					+ "1. Administrer brugere.\n"
					+ "2. Skift password.\n"
					+ "3. Afvejning.\n"
					+ "4. Afslut.\n"
					+ "Indtast et nummer mellem 1-4:");
			choice = scan.nextInt();

			if(choice == 1){
				admministrerUsers(scan);
				//				createUser(scan);
			}
			else if(choice == 2){
				changePassword(scan);
			}
			else if(choice == 3){
				balancing(scan);
			}
			else if(choice == 4){
				exit();
				System.out.println("Du har afsluttet applikationen. På gensyn.");
			}
			else{
				System.out.println("Du har indtastet et ugyldigt nummer. Prøv igen.");
			}
		}
		while(loop);
	}

	private void admministrerUsers(Scanner scan) throws DALException {

		System.out.println("Log venligst ind som System Admin for at administrere brugere.");

		loginSysAdmin(scan);

		do {
			System.out.println("Du har nu følgende valgmuligheder:\n"
					+ "1. Opret ny bruger.\n"
					+ "2. Slet bruger.\n"
					+ "3. Opdater bruger.\n"
					+ "4. Tilbage til hovedmenu.\n"
					+ "Indtast et nummer mellem 1-4:");

			choice = scan.nextInt();

			if(choice == 1){
				createUser(scan);
			}
			else if(choice == 2){
				deleteUser(scan);
			}
			else if(choice == 3){
				updateUser(scan);
			}
			else if(choice == 4){
				mainMenu(scan);
			}
			else{
				System.out.println("Du har indtastet et ugyldigt nummer. Prøv igen.");
			}
		} while(loop);
	}

	private void exit() {
		loop = false;
	}

	public void createUser(Scanner scan) throws DALException{
		
		// Lav for-løkke? der kan udskrive brugerID på den nye operator

		
		
		try {
			oCont.createOperatoer(tCont.createrOperator(scan));
		} catch(DALException e) {
			System.out.println(e.getMessage());
			loop = true;
		}

		System.out.println("Brugeren er nu oprettet med et midlertidigt password.\n");
	}


	public void deleteUser(Scanner scan) {
		
		System.out.println("Indtast bruger ID du ønsker at slette.");
		
		int deleteID;
		deleteID = scan.nextInt();
		
//		if(deleteID == oCont.getOperatoerList().get(0)) {
//			
//			
//			
//		}else
//			System.out.println("Det indtastede bruger ID er ikke gyldigt.");
	
}

	public void updateUser(Scanner scan) {
		
		System.out.println("Indtast bruger ID du ønsker at opdatere.");
		
		int updateID;
		updateID = scan.nextInt();
		
//		if(updateID == oCont.getOperatoer().get(oprId)) {
//			
//		}else
//			System.out.println("Det indtastede bruger ID er ikke gyldigt");
		
}

	public void changePassword(Scanner scan) throws DALException{

		do{
			System.out.println("Du har nu følgende valgmuligheder:\n"
					+ "1. Skift password.\n"
					+ "2. Gå tilbage.\n"
					+ "Indtast et nummer mellem 1-2:");
			choice = scan.nextInt();

			if(choice == 1){
				System.out.println("Skift password.");
				try {
					skiftKode(scan);
				} catch(DALException e) {
					System.out.println(e.getMessage());
					loop = true;
				}
			}
			else if(choice == 2){
				mainMenu(scan);
			}
			else{
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
			}
		}
		while(loop);
	}

	private void skiftKode(Scanner scan) throws DALException {
		String newpass2 = "";
		String newpass = " ";
		do {
			System.out.println("Indtast bruger nr.");
			int oprId = scan.nextInt();
			System.out.println("Indtast din gamle adgangskode");
			String password = scan.next();
			if(passwordCheck(oprId, password)) {
				System.out.println("Indtast din nye adgangskode");
				newpass = scan.next();
				System.out.println("Gentag din nye adgangskode");
				newpass2 = scan.next();
				if(newpass.equals(newpass2)) {
					if(oCont.changePassword(oprId, newpass));

					else
						throw new DALException( "Der skal være minimum et stort bogstav, et lille bogstav og et tal i din kode. "
								+ "Desuden skal den være minimum 6 karakterer lang.");
				} else
					throw new DALException("Koderne er ikke ens. Prøv igen.");
			} else {
				throw new DALException("Bruger nr og password passer ikke sammen.");
			}
		}while(!newpass.equals(newpass2));
	}

	public void balancing(Scanner scan) throws DALException{
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

	public boolean oprLogin(Scanner scan) throws DALException {
		String password;
		int oprId;

		System.out.println("Bruger nr.:");
		oprId = scan.nextInt();
		System.out.println("Password:");
		password = scan.next();

		return passwordCheck(oprId, password);

	}

	public boolean passwordCheck(int oprId, String password) throws DALException {
		for(int i = 0; i < oCont.getOperatoerList().size(); i++)
			if(oCont.getOperatoerList().get(i).getOprId() == oprId)
				if(oCont.getOperatoerList().get(i).getPassword(oprId).equals(password))
					return true;
		return false;
	}

	public double afvejning(Scanner scan) throws DALException {

		System.out.println("Afvejning.\n");
		System.out.println("Indtast emballage vægt i kg.");
		double emballage = scan.nextDouble();
		System.out.println("Indtast bruttovægt i kg.");
		double brutto = scan.nextDouble();

		double netto = brutto - emballage;

		return netto;

	}

	public boolean loginSysAdmin(Scanner scan) throws DALException{
		int oprId;
		String password;

		System.out.println("Bruger nr.:");
		oprId = scan.nextInt();
		System.out.println("Password:");
		password = scan.next();

		if(sysAdminOprId() == oprId && password.equals(sysAdminPassword())){
			// Her skal stå den metoder der adminisrerer brugere
			return true;
		}
		else{
			System.out.println("Forkert bruger nr. eller password. Du bliver ført tilbage til foregående menu. \n");
			mainMenu(scan);
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