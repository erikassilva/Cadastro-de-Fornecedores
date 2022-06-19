package dominio;

public class Telefone extends EntidadeDominio {
	
	private String ddd;
	private String numero;
	private String ddi;
	private TipoTelefone tipoTelefone;
		
	public Telefone(String ddd, String numero, String ddi, TipoTelefone tipoTelefone) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.ddi = ddi;
		this.tipoTelefone = tipoTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
}
