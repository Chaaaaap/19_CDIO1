package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import data.OperatorDTO;
import interfaces.IMenuController;
import interfaces.IOperatorDAO.DALException;

public class MenuController implements IMenuController {
	
	// Attributter
	private int choice;
	private boolean loop = true;
	private OperatorDAO oCont;

	// Konstruktør
	public MenuController() throws DALException {
		oCont = new OperatorDAO();
	}

	// Vores mainMenu som bliver udskrevet i konsollen.
	// Denne kører i et do/while loop, indtil man har indtastet et nummer,
	// som vil blive godkendt.
	public void mainMenu(Scanner scan) throws DALException, InputMismatchException{
		System.out.println("Velkommen til Afvejningssystemet!\n");
		try {
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
			//Jeg kan ikke få try/catch til at virke i main :(
		} catch(InputMismatchException e) {
			throw new InputMismatchException("Du indtastede ikke et tal.");
		}
	}
	
	// Konsolmenu for at administrere brugerne. Kan kun benyttes af sys admin.
	private void admministrerUsers(Scanner scan) throws DALException {

		System.out.println("Log venligst ind som System Admin for at administrere brugere.");
		loginSysAdmin(scan);
		do {
			System.out.println("Du har nu følgende valgmuligheder:\n"
					+ "1. Opret ny bruger.\n"
					+ "2. Slet bruger.\n"
					+ "3. Opdater bruger.\n"
					+ "4. Udskriv alle brugere.\n"
					+ "5. Tilbage til hovedmenu.\n"
					+ "Indtast et nummer mellem 1-5:");

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
			else if(choice == 4) {
				System.out.println(printAllOperators(oCont.getOperatoerList()));
			}
			else if(choice == 5){
				mainMenu(scan);
			}
			else{
				System.out.println("Du har indtastet et ugyldigt nummer. Prøv igen.");
			}
		} while(loop);
	}

	// Slutter vores applikation, ved at sætte loopet til false.
	private void exit() {
		loop = false;
	}

	// Her prøver vi at lave en ny bruger, hvis cpr-nummeret allerede 
	// er brugt, så vil den catch en exception.
	public void createUser(Scanner scan) throws DALException{
		try {
			oCont.createOperatoer(createrOperator(scan));				
		} catch(DALException e) {
			System.out.println(e.getMessage());
			loop = true;
		}
	}

	// Her opretter vi en bruger i konsollen, ved at indtaste nødvendige informationer,
	// ved scanneren.
	public OperatorDTO createrOperator(Scanner scan) throws DALException {

		boolean alreadyExist = false;
		String forNavn;
		String efterNavn;
		String cpr;
		OperatorDTO operator = null;

		System.out.println("Indtast fornavn på den nye operatør");
		forNavn = scan.next();
		System.out.println("Indtast efternavn på den nye operatør");
		efterNavn = scan.next();
		System.out.println("Indtast CPR-nummer for operatøren");
		cpr = scan.next();

		for(int i = 0; i < oCont.getOperatoerList().size(); i++) {
			if(oCont.getOperatoerList().get(i).getCPR() == cpr)
				alreadyExist = true;
		}

		if(cpr.length() < 11 || cpr.length() > 12) {
			throw new DALException("Fejl! Det indtastede CPR-nummer er ikke gyldigt. Det skal indtastes ddmmåå-xxxx");
		} else if(alreadyExist) {
			throw new DALException("Fejl! Det indtastede CPR-nummer er allerede tilknyttet en bruger!");
		}

		try {
			operator = new OperatorDTO(forNavn, efterNavn, cpr);
		} catch(DALException e) {
			System.out.println(e.getMessage());
		}
		if(operator != null)
			return operator;
		else
			return null;
	}

	// Her sletter vi en bruger fra systemet, ved at indtaste et bruger ID. 
	// Hvis dette ID er i systemet, vil denne bruger blive slettet.
	public void deleteUser(Scanner scan) {

		System.out.println("Indtast bruger ID du ønsker at slette.");

		int deleteID;
		deleteID = scan.nextInt();

		try {
			oCont.deleteOperatoer(oCont.getOperatoer(deleteID));
		} catch(DALException e){
			System.out.println(e.getMessage());
		}
	}

	// Her indtaster vi nye informationer om en bruger, som så overskriver de eksisterende. 
	// Dette bliver gjort ved at man indtaster hvilket bruger ID man ønsker at opdatere. 
	public void updateUser(Scanner scan) {
		String oprNavn = "";
		System.out.println("Indtast bruger ID du ønsker at opdatere.");
		int updateID = scan.nextInt();
		System.out.println("Indtast det nye CPR-nummer.");
		String cpr = scan.next();
		System.out.println("Indtast det nye fornavn.");
		oprNavn += scan.next() + " ";
		System.out.println("Indtast det nye efternavn.");
		oprNavn += scan.next();

		try {
			oCont.getOperatoer(updateID).updateOpr(oprNavn, cpr);
			oCont.updateOperatoer(oCont.getOperatoer(updateID));
		} catch(DALException e){
			System.out.println(e.getMessage());
		}
	}

	// Menuen for at skifte password.
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

	// Her indtaster vi bruger ID og det gamle password, for at kunne indtaste det nye.
	private void skiftKode(Scanner scan) throws DALException {
		String newpass2 = " ";
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

	// Menuen for afvejning.
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

	// I denne metode logger man ind som bruger.
	public boolean oprLogin(Scanner scan) throws DALException {
		String password;
		int oprId;

		System.out.println("Bruger nr.:");
		oprId = scan.nextInt();
		System.out.println("Password:");
		password = scan.next();

		return passwordCheck(oprId, password);
	}

	// Her ser vi på om det indtastede password stemmer overens med brugerens password. 
	public boolean passwordCheck(int oprId, String password) throws DALException {
		for(int i = 0; i < oCont.getOperatoerList().size(); i++)
			if(oCont.getOperatoerList().get(i).getOprId() == oprId)
				if(oCont.getOperatoerList().get(i).getPassword().equals(password))
					return true;
		return false;
	}

	// Menuen, hvor man indtaster værdierne, på det man vil afveje.
	public double afvejning(Scanner scan) throws DALException {

		System.out.println("Afvejning.\n");
		System.out.println("Indtast emballage vægt i kg.");
		double emballage = scan.nextDouble();
		System.out.println("Indtast bruttovægt i kg.");
		double brutto = scan.nextDouble();
		System.out.println("Din nettovægt i kg.");
		double netto = brutto - emballage;

		return netto;
	}

	// Metode, hvor man kan logge ind som sys Admin, som er hardcoded i systemet.
	public boolean loginSysAdmin(Scanner scan) throws DALException{
		int oprId;
		String password;

		System.out.println("Bruger nr.:");
		oprId = scan.nextInt();
		System.out.println("Password:");
		password = scan.next();

		if(oprId == 10 && password.equals(oCont.getOperatoer(10).getPassword())){
			return true;
		}
		else{
			System.out.println("Forkert bruger nr. eller password. Du bliver ført tilbage til foregående menu. \n");
			mainMenu(scan);
			return false;
		}
	}

	// Metode, hvor vi får udskrevet alle operatorer i systemet ud i konsollen.
	public String printAllOperators(List<OperatorDTO> list) {
		String toString = "OprID \tBrugernavn\tCPR-nummer\n";
		for (int i = 0; i < list.size(); i++) {
			toString += list.get(i).toString()+"\n";
		}
		return toString;
	}
}