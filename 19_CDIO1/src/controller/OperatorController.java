package controller;

import java.util.List;

import data.OperatorDTO;
import interfaces.IOperatorDAO;

public class OperatorController implements IOperatorDAO {
	
	private List<OperatorDTO> operatorList;
	private List<String> cprList;
	OperatorDTO data;
	
	public OperatorController() {
		
	}

	@Override
	public OperatorDTO getOperatoer(int oprId) {//throws DALException {
		for(int i = 0; i < operatorList.size(); i++)
			if(operatorList.get(i).getOprId() == oprId)
				return operatorList.get(i);
		return null;
	}

	@Override
	public List<OperatorDTO> getOperatoerList() throws DALException {
		// TODO Auto-generated method stub
		return operatorList;
	}

	@Override
	public void createOperatoer(OperatorDTO opr) throws DALException {
		operatorList.add(opr);
	}

	@Override
	public void updateOperatoer(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
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

}
