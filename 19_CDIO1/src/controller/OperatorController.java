package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.OperatorDTO;
import interfaces.IOperatorDAO;

public class OperatorController implements IOperatorDAO {

	private Map<Integer, OperatorDTO> operatorList = new HashMap<>();

	public OperatorController() {

	}

	@Override
	public OperatorDTO getOperatoer(int oprId) throws DALException {
		OperatorDTO operator = operatorList.get(oprId);
		if (operator != null) return operator;
		throw new DALException("han findes ikke - eller hun findes ikke - eller brugeren");

	}

	@Override
	public List<OperatorDTO> getOperatoerList() throws DALException {
		List<OperatorDTO> list = new ArrayList<>();
		list.addAll(operatorList.values());
		return list;
	}

	@Override
	public void createOperatoer(OperatorDTO opr) throws DALException {
		if (operatorList.get(opr.getOprId())!=null) throw new DALException("Brugeren findes Allerede");
		operatorList.put(opr.getOprId(), opr);
	}

	@Override
	public void updateOperatoer(OperatorDTO opr) throws DALException {
		if (operatorList.get(opr.getOprId())==null) throw new DALException("Brugeren findes ikke");
		operatorList.put(opr.getOprId(), opr);

	}

	@Override
	public void deleteOperatoer(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		operatorList.remove(opr);
	}

	public boolean passwordCheck(String oprNavn, String password) {
		for(int i = 0; i < operatorList.size(); i++)
			if(operatorList.get(i).getOprNavn(oprNavn).equals(oprNavn)) {
				if(operatorList.get(i).getPassword(oprNavn).equals(password))
					return true;
			}
		return false;
	}

	public boolean changePassword(int oprId, String newpass) {
		OperatorDTO operator = operatorList.get(oprId);
		if(operator.changePassword(newpass))
			return true;
		else
			return false;
	}

}
