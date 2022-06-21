package dominio;

import java.util.List;

public class Fornecedor extends EntidadeDominio {
	
	private boolean isRascunho;
	private int id;
	private String email;
	private String cnpj;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String rzSocial;
	private String nmFantasia;
	
	private String status;
	private String tipoFornecimento;
	private Endereco endereco;
	private List<Empresa> empresas;
	private List<Os> ordemServicos;
	private List<Servico> servicos;
	private List<Produto> produtos;
	private List<ContaBancaria> contasBancarias;
	private List<Telefone> telefones;
	private List<Cnae> cnaes;
	private List<Contato> contatos;
	
	
	public Fornecedor(String email, String cnpj, String inscricaoEstadual, String inscricaoMunicipal,
			String rzSocial, String nmFantasia, String status, String tipoFornecimento, Endereco endereco) {
		super();
		this.email = email;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.rzSocial = rzSocial;
		this.nmFantasia = nmFantasia;
		this.status = status;
		this.tipoFornecimento = tipoFornecimento;
		this.endereco = endereco;
	}
		
	public Fornecedor() {
		super();
	}

	public boolean isRascunho() {
		return isRascunho;
	}
	public void setRascunho(boolean isRascunho) {
		this.isRascunho = isRascunho;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public String getRzSocial() {
		return rzSocial;
	}
	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
	}
	public String getNmFantasia() {
		return nmFantasia;
	}
	public void setNmFantasia(String nmFantasia) {
		this.nmFantasia = nmFantasia;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipoFornecimento() {
		return tipoFornecimento;
	}
	public void setTipoFornecimento(String tipoFornecimento) {
		this.tipoFornecimento = tipoFornecimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	public List<Os> getOrdemServicos() {
		return ordemServicos;
	}
	public void setOrdemServicos(List<Os> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<ContaBancaria> getContasBancarias() {
		return contasBancarias;
	}
	public void setContasBancarias(List<ContaBancaria> contasBancarias) {
		this.contasBancarias = contasBancarias;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Cnae> getCnaes() {
		return cnaes;
	}
	public void setCnaes(List<Cnae> cnaes) {
		this.cnaes = cnaes;
	}
	public List<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
		
}
