package dominio;

public class Ramal extends Telefone {
	
	private String codigo;
	private String descricao;
	
	public Ramal(String ddd, String numero, String ddi, TipoTelefone tipoTelefone, String codigo, String descricao) {
		super(ddd, numero, ddi, tipoTelefone);
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Ramal() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
