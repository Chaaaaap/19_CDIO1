package interfaces;

import java.util.List;

import data.OperatorDTO;

public interface IOperatorDAO {
	
	public class DALException extends Exception {

		/****************************************************************
		* Den ville meget gerne have et serienummer så det har den fået.*
		****************************************************************/
		private static final long serialVersionUID = 1L;
		public DALException(String msg) {
			super(msg);
		}

	}

	OperatorDTO getOperatoer(int oprId) throws DALException;

	List<OperatorDTO> getOperatoerList() throws DALException;

	void createOperatoer(OperatorDTO opr) throws DALException;

	void updateOperatoer(OperatorDTO opr) throws DALException;

	void deleteOperatoer(OperatorDTO opr) throws DALException;

}
