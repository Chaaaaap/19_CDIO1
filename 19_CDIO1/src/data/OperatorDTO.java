package data;

import interfaces.IOperatorDAO.DALException;

public class OperatorDTO {
	
	// Attributter
	private static int oprID = 10;
	private int oprId;		//Skal automatisk tildeles en bruger ved oprettelse. Mellem 11-99
	private String oprNavn;	//Minimum 2 og max 20 karakterer.
	private String ini =  new String();		//2-3 karakterer til initialer.
	private String cpr;		//Skal skrives med bindestreg
	private String password;	

	// Konstruktør
	public OperatorDTO(String forNavn, String efterNavn, String cpr) throws DALException {
		oprNavn = forNavn;
		oprNavn += " " + efterNavn;
		this.cpr = cpr;
		ini += forNavn.charAt(0) + efterNavn.charAt(0);
		password = createTempPassword();
		if(oprID <= 99) {
		oprId = oprID;
		oprID++;
		} else {
			throw new DALException("Du har desværre overskredet maximum antal brugere.");
		}
	}
	
	// Opretter et midlertidigt password
	private String createTempPassword() {
		return "Test1234";
	}

	public String getOprNavn() {
		return oprNavn;
	}

	public String getPassword() {
		return password;
	}

	public String getCPR() {
		return cpr;
	}

	// Vores data, for kravene for selve passwordet.
	public boolean changePassword(String newpass) throws DALException{
		int capitalLetter = 0;
		int smallLetter = 0;
		int number = 0;
		int passwordLength = 0;
		if(newpass.length() >= 6) {
			for(int i = 0; i < newpass.length(); i++){
				if(newpass.charAt(i) >= 'A' && newpass.charAt(i) <= 'Z') {
					capitalLetter = 1;
				}
				if(newpass.charAt(i) >= 'a' && newpass.charAt(i) <= 'z') {
					smallLetter = 1;
				}
				if(newpass.charAt(i) >= '0' && newpass.charAt(i) <= '9'){
					number = 1;
				}
			}
			if(capitalLetter+smallLetter+number+passwordLength >= 3) {
				password = newpass;
				return true;
			}
			throw new DALException("Passwordet skal indeholde minimum et stort tegn, et lille tegn og et tal.");
		} else {
			throw new DALException("Passwordet skal minimum være 6 tegn langt.");
		}
	}

	public int getOprId() {
		return oprId;
	}
	
	// metode til at opdatere vores operatører.
	public void updateOpr(String oprNavn, String cpr) throws DALException {
		this.oprNavn = oprNavn;
		this.cpr = cpr;
		if(cpr.length() < 11 && cpr.length() > 11) throw new DALException("CPR-nummeret er ikke gyldigt. Det skal skrives ddmmåå-xxxx");
		password = createTempPassword();
	}
	
	public String toString() {
		return oprId+"\t"+oprNavn+"\t"+cpr;
	}
}