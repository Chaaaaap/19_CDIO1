package controller;

import java.util.List;

import data.OperatorDTO;
import interfaces.IOperatorDAO;

public class OperatorController implements IOperatorDAO {
	
	OperatorDTO data;
	
	public OperatorController() {
		
	}

	@Override
	public OperatorDTO getOperatoer(int oprId) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OperatorDTO> getOperatoerList() throws DALException {
		// TODO Auto-generated method stub
		return data.getOperatorList();
	}

	@Override
	public void createOperatoer(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		data.getOperatorList().add(opr);
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

}
