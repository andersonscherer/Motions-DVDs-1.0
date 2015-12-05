package Model;

import java.time.LocalDate;

public class Cliente {

	private Long codigo;
	private String nomeCliente;
	private String cpfCliente;
	private String sexo;
	private String registroGeral;
	private LocalDate dataNascimento;
	private String rua;
	private String numero;
	private String bairro;
	private String complemento;
	private Cidade cidade;
	private String telefone;
	private String telefone2;
	private String email;
	private Double rendaMensal;

	public Cliente() {

	}

	public Cliente(Long codigo, String nomeCliente, String cpfCliente,
			String sexo, String registroGeral, LocalDate dataNascimento,
			String rua, String numero, String bairro, String complemento,
			Cidade cidade, String telefone, String telefone2, String email,
			Double rendaMensal) {
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.sexo = sexo;
		this.registroGeral = registroGeral;
		this.dataNascimento = dataNascimento;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.telefone2 = telefone2;
		this.email = email;
		this.rendaMensal = rendaMensal;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String toString() {
		return "Cpf: " + cpfCliente + "Nome:" + nomeCliente;
	}

}
