package dominio;

public class Servico extends EntidadeDominio {
	
	private int id;
	private String descricao;
	private Os os;
	
	public Servico(String descricao) {
		super();
		this.descricao = descricao;
	}
		
	public Servico() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Os getOs() {
		return os;
	}

	public void setOs(Os os) {
		this.os = os;
	}

}
