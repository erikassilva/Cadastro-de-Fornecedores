package dominio;

import java.util.List;

public class Contato extends Pessoa {
	
	private String email;
	private Departamento departamento;
	private Telefone telefone;
	
	public Contato(String nome, List<Usuario> usuarios, String email, Departamento departamento, Telefone telefone) {
		super(nome, usuarios);
		this.email = email;
		this.departamento = departamento;
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
				
}
