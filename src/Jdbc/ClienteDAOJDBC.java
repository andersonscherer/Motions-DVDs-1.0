package Jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ConexaoBanco.ConexaoUtil;
import Dao.ClienteDAO;
import Model.Cliente;

public class ClienteDAOJDBC implements ClienteDAO {

	private Connection con;
	
	public ClienteDAOJDBC(){
		con = ConexaoUtil.getCon();
	}
	
	public void inserir(Cliente cliente) {
		
		String sql = "insert into tb_cliente (nome ,cpf, sexo, rg, dataNascimento,"
				+ "rua, numero, bairro, complemento, cidade, telefone, telefone2,"
				+ "email,rendaMensal) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cliente.getNomeCliente());
			pstmt.setString(2, cliente.getCpfCliente());
			pstmt.setString(3, cliente.getSexo());
			pstmt.setString(4, cliente.getRegistroGeral());
			pstmt.setDate(5, Date.valueOf(cliente.getDataNascimento()));
			pstmt.setString(6, cliente.getRua());
			pstmt.setString(7, cliente.getNumero());
			pstmt.setString(8, cliente.getBairro());
			pstmt.setString(9, cliente.getComplemento());
			pstmt.setLong(10, cliente.getCidade().getIdCidade());
			pstmt.setString(11, cliente.getTelefone());
			pstmt.setString(12, cliente.getTelefone2());
			pstmt.setString(13, cliente.getEmail());
			pstmt.setDouble(14, cliente.getRendaMensal());
			//Realizando a gravaçao dos Dados no Banco
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Cliente cliente) {
		String sql = "update cliente set rua = ?, numero = ?, bairro = ?,  complemento = ?, rendaMensa = ?, telefone ? "
				+ "where cpf = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(6, cliente.getRua());
			pstmt.setString(7, cliente.getNumero());
			pstmt.setString(8, cliente.getBairro());
			pstmt.setString(9, cliente.getComplemento());
			pstmt.setDouble(11, cliente.getRendaMensal());
			pstmt.setString(12, cliente.getTelefone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void excluir(Cliente cliente) {
		String sql = "delete from cliente where cpf = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cliente buscar(String cpf) {
		Cliente cliente = null;
		String sql = "select * from tb_cliente where cpf = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cpf);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("idCliente"));
				cliente.setCpfCliente(rs.getString("cpf"));
				cliente.setNomeCliente(rs.getString("nome"));
				cliente.setRegistroGeral(rs.getString("rg"));
				cliente.setDataNascimento(LocalDate.parse(rs.getDate("dataNascimento").toString()));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setTelefone(rs.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	public Cliente buscarCidade(Integer cidadeBusca) {
		Cliente cliente = null;
		String sql = "select cpf, nome, telefone from tb_cliente where cidade = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cidadeBusca);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				cliente = new Cliente();
				cliente.setCpfCliente(rs.getString("cpf"));
				cliente.setNomeCliente(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	public List<Cliente> todos() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "select * from tb_cliente";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setCpfCliente(rs.getString("cpf"));
				cliente.setNomeCliente(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public Cliente buscar(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
