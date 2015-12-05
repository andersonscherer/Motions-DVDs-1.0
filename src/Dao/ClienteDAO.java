package Dao;

import Generic.GenericDAO;
import Model.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente>{

	Cliente buscar(String cpf);
	
}