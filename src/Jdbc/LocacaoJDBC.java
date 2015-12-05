package Jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import ConexaoBanco.ConexaoUtil;
import Dao.ClienteDAO;
import Dao.LocacaoDAO;
import Model.Locacao;

public class LocacaoJDBC implements LocacaoDAO {

	private Connection con;

	public LocacaoJDBC() {
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Locacao locacao) {
		// INSERIR UMA LOCACAO

		String sql = "insert into tb_locacao(cliente, fita, valorTotal, dataLocacao) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, locacao.getCliente().getCodigo());
			pstmt.setInt(2, locacao.getFita().getCodigo());
			pstmt.setDouble(3, locacao.getValorTotal());
			pstmt.setDate(4, Date.valueOf(locacao.getDataLocacao()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Locacao entidade) {
		// ALTERAR UMA LOCAÇÃO
		
		
	}

	@Override
	public void excluir(Locacao entidade) {
		// ATENÇÃO NÃO PODE ALTERAR UMA LOCAÇÃO
		
	}

	@Override
	public List<Locacao> todos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buscar(Integer id) {
		//BUSCAR UMA LOCACAO
		ClienteDAO clienteDAO =new ClienteDAOJDBC();
		Locacao locacao = null;
		String sql = "select * from tb_locacao where idFita = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				locacao = new Locacao();
				locacao.setCodigo(rs.getInt("idLocacao"));
				locacao.setCliente(clienteDAO.buscar(rs.getString("cpf")));
				//locacao.setFita(new Fita(rs.getInt("idFita")));
				locacao.setDataLocacao(LocalDate.parse(rs.getString("")));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Locacao buscar(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}