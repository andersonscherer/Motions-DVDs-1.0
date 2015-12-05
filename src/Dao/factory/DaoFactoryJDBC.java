package Dao.factory;

import Dao.ClienteDAO;
import Dao.FitaDAO;
import Jdbc.ClienteDAOJDBC;
import Jdbc.FitaDAOJDBC;

/**
 * Fabrica concreta de Dao do tipo JDBC
 * @author Anderson
 *
 */
public class DaoFactoryJDBC implements AbstractDaoFactory{

	@Override
	public ClienteDAO clienteDao() {
		return new ClienteDAOJDBC();
	}
	
	public FitaDAO fitaDao() {
		return new FitaDAOJDBC();
	}
	
}
