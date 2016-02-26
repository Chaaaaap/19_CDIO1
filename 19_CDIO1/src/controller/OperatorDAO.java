package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.OperatorDTO;
import interfaces.IOperatorDAO;

public class OperatorDAO implements IOperatorDAO {

	// Attributter
	private Map<Integer, OperatorDTO> operatorList = new HashMap<>();

	// Konstruktør
	public OperatorDAO() throws DALException {
		//oprId 10 aka System Admin
		OperatorDTO sysAdmin = new OperatorDTO("Sys", "Admin", "133337-1337");
		createOperatoer(sysAdmin);
		sysAdmin.changePassword("Abc02324");
		//oprId 11
		OperatorDTO operator1 = new OperatorDTO("Mikkel", "Hansen", "123456-1233");
		createOperatoer(operator1);
		//oprId 12
		OperatorDTO operator2 = new OperatorDTO("Silas", "Stryhn", "654321-4321");
		createOperatoer(operator2);
		//oprId 13
		OperatorDTO operator3 = new OperatorDTO("Frank", "Thomsen", "124578-1285");
		createOperatoer(operator3);
	}

	@Override
	public OperatorDTO getOperatoer(int oprId) throws DALException {
		OperatorDTO operator = operatorList.get(oprId);
		if (operator != null) return operator;
		throw new DALException("Brugeren findes ikke.");
	}

	@Override
	public List<OperatorDTO> getOperatoerList() throws DALException {
		List<OperatorDTO> list = new ArrayList<>();
		list.addAll(operatorList.values());
		return list;
	}

	// Her opretter vi vores operatører og opdatere vores operatorlist.
	@Override
	public void createOperatoer(OperatorDTO opr) throws DALException {
		if (operatorList.get(opr.getOprId())!=null) throw new DALException("Brugeren findes Allerede");
		operatorList.put(opr.getOprId(), opr);
	}

	// Her opdatere vi operatørerne, hvis de skal have ændret navn eller cpr nummer. 
	// Vi opdatere informationerne på vores operatorlist.
	@Override
	public void updateOperatoer(OperatorDTO opr) throws DALException {
		if (operatorList.get(opr.getOprId())==null) throw new DALException("Brugeren findes ikke");
		operatorList.put(opr.getOprId(), opr);
	}

	// Her sletter vi operatørerne og opdatere det på vores operatorlist.
	@Override
	public void deleteOperatoer(OperatorDTO opr) throws DALException {
		if(opr.getOprId() == 10) 
			throw new DALException("Man kan ikke slette System Admin.");
		else
			operatorList.remove(opr.getOprId(), opr);
	}

	// Her skifter vi passwordet på en operator.
	public boolean changePassword(int oprId, String newpass) throws DALException {
		OperatorDTO operator = operatorList.get(oprId);
		if(operator.changePassword(newpass))
			return true;
		else
			return false;
	}
}