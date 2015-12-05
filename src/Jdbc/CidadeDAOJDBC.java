package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConexaoBanco.ConexaoUtil;
import Dao.CidadeDAO;
import Model.Cidade;

public class CidadeDAOJDBC implements CidadeDAO{

	private Connection con;

	public CidadeDAOJDBC() {
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Cidade entidade) {
		// NAO USA
		
	}

	@Override
	public void alterar(Cidade entidade) {
		// NAO USA
		
	}

	@Override
	public void excluir(Cidade entidade) {
		// NAO USA
		
	}

	@Override
	public Cidade buscar(Long codigo) {
		// NAO USA
		return null;
	}

	@Override
	public List<Cidade> todos() {
		List<Cidade> cidades = new ArrayList<>();
		String sql = "select * from tb_cidade";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				cidades.add(new Cidade(rs.getInt("idCidade"), rs.getString("nome")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cidades;
	}

}
