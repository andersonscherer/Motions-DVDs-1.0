package Dao.factory;

import Dao.ClienteDAO;
import Dao.FitaDAO;

/**
 * Fabrica de DAO, inicializa a fabrica correta para 
 * o tipo de sistema e disponibiza os métodos de acesso a construção do DAO 
 * @author forchesatto
 *
 */
public class DaoFactory {
	
	private static DaoFactory factory;
	
	private static final String tipoSistema = "BANCO";
	
	private static AbstractDaoFactory daoFactory;
	
	/**
	 * Constroi a fabrica correta de DAO.
	 * @return
	 */
	public static DaoFactory get(){
		if(factory == null){
			factory = new DaoFactory();
		}
		//Decide se é banco ou TXT
		//Aqui podemos definir via parametro de um arquivo se é uma ou outra impl
		if(tipoSistema.equals("BANCO")){
			daoFactory = new DaoFactoryJDBC();
		}

		return factory;
	}

	/**
	 * Disponibiliza o DAO com base na fabrica construida dinamicamente.
	 * @return
	 */
	public ClienteDAO clienteDao(){
		return daoFactory.clienteDao();
	}
	
	public FitaDAO fitaDao(){
		return daoFactory.fitaDao();
	}
}
