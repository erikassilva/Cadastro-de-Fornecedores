package dominio;

import java.util.Date;

public class Cnae extends EntidadeDominio {
	
	private String numero;
	
	public Cnae(String numero) {
		this.numero = numero;
		this.dtCadastro = new Date();
	}
	
	public Cnae() {
		super();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
		
}
