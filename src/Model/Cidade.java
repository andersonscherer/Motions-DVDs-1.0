package Model;

import ComboBox.*;

public class Cidade implements PossuiNome {

	private Integer idCidade;
	private String nome;

	public Cidade() {

	}

	public Cidade(Integer idCidade, String nome) {
		super();
		this.idCidade = idCidade;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
