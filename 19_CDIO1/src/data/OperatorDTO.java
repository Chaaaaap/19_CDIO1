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
	
	public OperatorDTO() {
		
	}
	
	public void createOperator(String forNavn, String efterNavn, String oprNavn) {
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
	
	public OperatorDTO getOperator(String cpr) {
		for(int i = 0; i < operatorList.size(); i++)
			if(operatorList.get(i).cpr.equals(cpr))
				return operatorList.get(i);
		return null;
	}
	
	public String getOprNavn(String cpr) {
		for(int i = 0; i < operatorList.size(); i++)
			if(operatorList.get(i).cpr.equals(cpr))
				return oprNavn;
		return null;
	}
	
	public String getPassword(String cpr) {
		for(int i = 0; i < operatorList.size(); i++)
			if(operatorList.get(i).cpr.equals(cpr))
				return operatorList.get(i).password;
		return null;
	}
	
	public int getOprId() {
		for(int i = 0; i < operatorList.size(); i++)
			if(operatorList.get(i).oprId == oprId)
				return oprId;
		return -1;
	}
	
	public String getCPR() {
		return cpr;
	}

}
