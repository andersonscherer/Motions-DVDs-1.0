package Dao;

import Generic.GenericDAO;
import Model.Locacao;

public interface LocacaoDAO extends GenericDAO<Locacao> {
	void buscar(Integer id);
}
