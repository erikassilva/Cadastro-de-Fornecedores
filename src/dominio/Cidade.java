package dominio;

public class Cidade {
	
	private String descricao;
	private Uf uf;
	
	public Cidade(String descricao, Uf uf) {
		super();
		this.descricao = descricao;
		this.uf = uf;
	}
	
	public Cidade() {
		super();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

}
