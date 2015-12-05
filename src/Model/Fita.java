package Model;

import java.time.LocalDate;

public class Fita {

	private Integer codigo;
	private String titulo;
	private GenerosFilme genero;
	private LocalDate dataLancamento;
	private String sinopse;
	private String diretor;
	private String duracao;
	private String origem;
	private String ano;
	private Double precoAluguel;
	
	private String status;
	
	public Fita(Integer codigo, String titulo, GenerosFilme genero,
			LocalDate dataLancamento, String sinopse, String diretor,
			String duracao, String origem, Double precoAluguel, String ano, String status) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.genero = genero;
		this.dataLancamento = dataLancamento;
		this.sinopse = sinopse;
		this.diretor = diretor;
		this.duracao = duracao;
		this.origem = origem;
		this.precoAluguel = precoAluguel;
		this.ano = ano;
		this.status = status;
	}

	
	public Fita() {
		super();
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public GenerosFilme getGenero() {
		return genero;
	}

	public void setGenero(GenerosFilme genero) {
		this.genero = genero;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Double getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(Double precoAluguel) {
		this.precoAluguel = precoAluguel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
	
}
