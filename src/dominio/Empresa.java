package dominio;

import java.util.List;

public class Empresa extends EntidadeDominio {
	
	private List <Fornecedor> fornecedores;
	private TipoEmpresa tipoEmpresa;
	
	public Empresa(List<Fornecedor> fornecedores, TipoEmpresa tipoEmpresa) {
		super();
		this.fornecedores = fornecedores;
		this.tipoEmpresa = tipoEmpresa;
	}
	
	public Empresa() {
		super();
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	
}
