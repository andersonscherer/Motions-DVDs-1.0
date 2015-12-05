package Model;

import java.time.LocalDate;

public class Locacao {

	private Integer codigo;
	private Cliente cliente;
	private Fita fita;
	private LocalDate dataLocacao;
	private Double valorTotal;
	
	public Locacao() {
	
	}
	
	public Locacao(Integer codigo, Cliente cliente, Fita fita, LocalDate dataLocacao, Double valorTotal) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.fita = fita;
		this.dataLocacao = dataLocacao;
		this.valorTotal = valorTotal;
	}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Fita getFita() {
		return fita;
	}

	public void setFita(Fita fita) {
		this.fita = fita;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setvalorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	
}
