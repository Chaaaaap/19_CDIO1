package controller;

import java.util.List;

import data.OperatorDTO;
import interfacej.DALException;
import interfacej.IOperatorDAO;

public class OperatorController implements IOperatorDAO {
	
	List<OperatorDTO> operatorList;

	@Override
	public OperatorDTO getOperatoer(int oprId) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OperatorDTO> getOperatoerList() throws DALException {
		// TODO Auto-generated method stub
		return operatorList;
	}

	@Override
	public void createOperatoer(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOperatoer(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOperatoer(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
