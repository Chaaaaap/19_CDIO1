package data;

import java.util.List;

public class OperatorDTO {
	
	int oprId;		//Skal automatisk tildeles en bruger ved oprettelse. Mellem 11-99
	String oprNavn;	//Minimum 2 og max 20 karakterer.
	String ini;		//2-3 karakterer til initialer.
	String cpr;		//Skal skrives uden bindestreg
	String password;
	List<OperatorDTO> operatorList;
	List<String> cprList;
	
	public OperatorDTO(String forNavn, String efterNavn, String cpr, int oprId) {
		oprNavn += forNavn+" ";
		oprNavn += efterNavn;
		this.cpr = cpr;
		this.oprId = oprId;
	}
	
	public void createOperator() {
		new OperatorDTO("Mikkel", "Hansen", "190792-1685", 19);
		operatorList.add(this);
		cprList.add(cpr);
		password = createTempPassword();
		
	}

	private String createTempPassword() {
		// Opretter et midlertidigt password
		return "Test1234";
	}

	public List<OperatorDTO> getOperatorList() {
		return operatorList;
	}

}
