package dominio;

public class TipoTelefone {
	
	private String descricao;

	public TipoTelefone(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	public TipoTelefone() {
		super();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
