package dominio;

import java.util.List;

public class Contato extends Pessoa {
	
	private String email;
	private Departamento departamento;
	private Telefone telefone;
	
	public Contato(String nome, String email, Departamento departamento) {
		super(nome);
		this.email = email;
		this.departamento = departamento;
	}
	
	public Contato() {
		super();
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
