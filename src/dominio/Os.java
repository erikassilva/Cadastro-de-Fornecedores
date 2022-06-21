package dominio;

import java.util.List;

public class Os extends EntidadeDominio {
	
	private long dtInicio;
	private Fornecedor fornecedor;
	private List <Servico> servicos;
	
	public Os(long dtInicio) {
		super();
		this.dtInicio = dtInicio;
	}
	
	public Os() {
		super();
	}

	public long getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(long dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
		
}
