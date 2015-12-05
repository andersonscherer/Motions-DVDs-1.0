package Jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConexaoBanco.ConexaoUtil;
import Dao.FitaDAO;
import Dao.GenerosFilmeDAO;
import Model.Fita;

public class FitaDAOJDBC implements FitaDAO {

	private Connection con;
	private GenerosFilmeDAO generoDao;

	public FitaDAOJDBC() {
		generoDao = new GenerosFilmeDAOJDBC();
		con = ConexaoUtil.getCon();
	}

	public void inserir(Fita fita) {
		String sql = "insert into tb_fita (titulo, genero, dataLancamento,sinopse, diretor,"
				+ "duracao, origem, ano, valor, status) values " + "(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fita.getTitulo());
			pstmt.setLong(2, fita.getGenero().getIdGenero());
			pstmt.setDate(3, Date.valueOf(fita.getDataLancamento()));
			pstmt.setString(4, fita.getSinopse());
			pstmt.setString(5, fita.getDiretor());
			pstmt.setString(6, fita.getDuracao());
			pstmt.setString(7, fita.getOrigem());
			pstmt.setString(8, fita.getAno());
			pstmt.setDouble(9, fita.getPrecoAluguel());			
			pstmt.setString(10, fita.getStatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Fita fita) {
		String sql = "update tb_fita where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fita.getTitulo());
			pstmt.setLong(2, fita.getGenero().getIdGenero());
			pstmt.setDate(3, Date.valueOf(fita.getDataLancamento()));
			pstmt.setString(4, fita.getSinopse());
			pstmt.setString(5, fita.getDiretor());
			pstmt.setString(6, fita.getDuracao());
			pstmt.setString(7, fita.getOrigem());
			pstmt.setString(8, fita.getAno());
			pstmt.setDouble(9, fita.getPrecoAluguel());			
			pstmt.setString(10, fita.getStatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Fita fita) {
		String sql = "delete from cliente where idCliente = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fita.getTitulo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Fita buscar(Integer codigoFita) {
		Fita fita = null;
		String sql = "select * from tb_fita where idFita = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, codigoFita);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				fita = new Fita();
				fita.setCodigo(rs.getInt("idFita"));
				fita.setTitulo(rs.getString("titulo"));
				fita.setDiretor(rs.getString("diretor"));
				fita.setDuracao(rs.getString("duracao"));
				fita.setOrigem(rs.getString("origem"));
				fita.setPrecoAluguel(rs.getDouble("valor"));
				fita.setStatus(rs.getString("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fita;
	}

	
	public List<Fita> todos() {
		List<Fita> fitas = new ArrayList<>();
		String sql = "select * from tb_fita";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Fita fita = new Fita();
				fita.setTitulo(rs.getString("titulo"));
				fita.setGenero(generoDao.buscar(rs.getLong("genero")));
				fita.setSinopse(rs.getString("sinopse"));
				fitas.add(fita);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fitas;
	}

	@Override
	public Fita buscar(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
