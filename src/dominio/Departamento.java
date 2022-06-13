package dominio;

public class Departamento extends EntidadeDominio {
	
	private String descricao;

	public Departamento(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
