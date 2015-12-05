package Dao.factory;

import Dao.ClienteDAO;
import Dao.FitaDAO;

public interface AbstractDaoFactory {

	/**
	 * Retorna uma implementação valida de ProdutoDAO
	 * @return ProdutoDAO
	 */
	ClienteDAO clienteDao();
	
	FitaDAO fitaDao();
}
