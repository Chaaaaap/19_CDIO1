package data;


public class OperatorDTO {
	private int oprID = 11;
	private int oprId;		//Skal automatisk tildeles en bruger ved oprettelse. Mellem 11-99
	private String oprNavn;	//Minimum 2 og max 20 karakterer.
	private String ini =  new String();		//2-3 karakterer til initialer.
	private String cpr;		//Skal skrives med bindestreg
	private String password;	

	public OperatorDTO(String forNavn, String efterNavn, String cpr) {
		oprNavn = forNavn;
		oprNavn += efterNavn;
		this.cpr = cpr;
		ini += forNavn.charAt(0) + efterNavn.charAt(0);
		password = createTempPassword();
		oprId = oprID;
		oprID++;
	}

	private String createTempPassword() {
		// Opretter et midlertidigt password
		return "Test1234";
	}

	public String getOprNavn(String cpr) {
		return oprNavn;
	}

	public String getPassword(String cpr) {
		return password;
	}

	public String getPassword(int oprId) {
		return password;
	}

	public String getCPR() {
		return cpr;
	}

	public boolean changePassword(String newpass) {
		int capitalLetter = 0;
		int smallLetter = 0;
		int number = 0;
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
		if(capitalLetter+smallLetter+number >= 3) {
			password = newpass;
			return true;
		}
		return false;
	}

	public int getOprId() {
		return oprId;
	}

}
