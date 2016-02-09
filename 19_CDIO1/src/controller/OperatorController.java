package controller;

import java.util.List;

import data.OperatorDTO;
import interfaces.IOperatorDAO;

public class OperatorController implements IOperatorDAO {
	
	OperatorDTO data;
	
	public OperatorController() {
		
	}

	@Override
	public OperatorDTO getOperatoer(int oprId) {//throws DALException {
		for(int i = 0; i < data.getOperatorList().size(); i++)
			if(data.getOperatorList().get(i).getOprId() == oprId)
				return data.getOperatorList().get(i);
		return null;
	}

	@Override
	public List<OperatorDTO> getOperatoerList() throws DALException {
		// TODO Auto-generated method stub
		return data.getOperatorList();
	}

	@Override
	public void createOperatoer(OperatorDTO opr) throws DALException {
		data.getOperatorList().add(opr);
	}

	@Override
	public void updateOperatoer(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOperatoer(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		data.getOperatorList().remove(opr);
	}
	
	public boolean passwordCheck(String oprNavn, String password) {
		for(int i = 0; i < data.getOperatorList().size(); i++)
			if(data.getOperatorList().get(i).getOprNavn(oprNavn).equals(oprNavn)) {
				if(data.getOperatorList().get(i).getPassword(oprNavn).equals(password))
					return true;
			}
		return false;
				
	}

}
