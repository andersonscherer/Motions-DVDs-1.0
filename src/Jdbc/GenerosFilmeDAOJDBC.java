package Jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConexaoBanco.ConexaoUtil;
import Dao.GenerosFilmeDAO;
import Model.GenerosFilme;

public class GenerosFilmeDAOJDBC implements GenerosFilmeDAO {

	private java.sql.Connection con;
	
	public GenerosFilmeDAOJDBC(){
		con = ConexaoUtil.getCon();
	}
	
	public List<GenerosFilme> todos() {
		List<GenerosFilme> generos = new ArrayList<>();
		String sql = "select * from tb_genero";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				GenerosFilme genero = new GenerosFilme();
				genero.setIdGenero(rs.getLong("igGenero"));
				genero.setNome(rs.getString("genero"));
				generos.add(genero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generos;
	}

	@Override
	public void inserir(GenerosFilme entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(GenerosFilme entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(GenerosFilme entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GenerosFilme buscar(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
