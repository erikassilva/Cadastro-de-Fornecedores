package dominio;

import java.util.List;

public class Pais {
	
	private String descricao;
	private List <Uf> ufs;
	
	public Pais(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	
	public Pais() {
		super();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Uf> getUfs() {
		return ufs;
	}

	public void setUfs(List<Uf> ufs) {
		this.ufs = ufs;
	}
			
}
