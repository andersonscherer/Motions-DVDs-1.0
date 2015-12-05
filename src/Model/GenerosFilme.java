package Model;

public class GenerosFilme {

	private Long idGenero;
	private String nome;

	public GenerosFilme() {
		super();
	}

	public GenerosFilme(Long idGenero, String nome) {
		super();
		this.idGenero = idGenero;
		this.nome = nome;
	}

	public Long getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}
	
}
