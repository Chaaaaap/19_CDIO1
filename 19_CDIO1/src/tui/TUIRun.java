package tui;

import java.util.Scanner;

public class TUIRun {
	
	TUIController cont = new TUIController();
	Scanner scan;
	int choice;
	
	public void mainMenu(){
		scan = new Scanner(System.in);
		System.out.println("Velkommen til denne 'applikation'!\n");
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
		}
		else if(choice == 2){
			changePassword();
		}
		else if(choice == 3){
			balancing();
		}
		else if(choice == 4){
			System.out.println("Du har afsluttet applikation. På gensyn.");
		}
		else
			System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
		}
		while(choice > 4);
		scan.close();

	}
	
	public void createUser(){
		scan = new Scanner(System.in);
		System.out.println("Du har nu følgende valgmuligheder:\n"
							+ "1. Opret ny bruger.\n"
							+ "2. Gå tilbage.\n"
							+ "Indtast et nummer mellem 1-2:");
		do{
		choice = scan.nextInt();
		
		if(choice == 1){
			cont.createrOperator();
		}
		else if(choice == 2){
			mainMenu();
		}
		else
			System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
		}
		while(choice > 2);
		scan.close();
	}
	
	public void changePassword(){
		scan = new Scanner(System.in);
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
			}
			else
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
			}
			while(choice > 2);
			scan.close();
	}
	
	public void balancing(){
		scan = new Scanner(System.in);
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
			}
			else
				System.out.println("Du har indtastet et ikke gyldigt nummer. Prøv igen.");
			}
			while(choice > 2);
			scan.close();
	}
}