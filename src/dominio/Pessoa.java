package dominio;

import java.util.List;

public class Pessoa extends EntidadeDominio {
	
	private String nome;
	private List<Usuario> usuarios;
	
	public Pessoa(String nome, List<Usuario> usuarios) {
		super();
		this.nome = nome;
		this.usuarios = usuarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
