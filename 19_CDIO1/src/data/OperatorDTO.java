package data;

public class OperatorDTO {
	
	int oprId;		//Skal automatisk tildeles en bruger ved oprettelse. Mellem 11-99
	String oprNavn;	//Minimum 2 og max 20 karakterer.
	String ini;		//2-3 karakterer til initialer.
	int cpr;		//Skal skrives uden bindestreg
	String password;
	
	public OperatorDTO(String forNavn, String efterNavn, int cpr) {
		oprNavn += forNavn+" ";
		oprNavn += efterNavn;
		this.cpr = cpr;
		oprId = 0;
	}

}
