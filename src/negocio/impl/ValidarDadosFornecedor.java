package negocio.impl;

import dominio.EntidadeDominio;
import dominio.Fornecedor;
import negocio.IStrategy;

public class ValidarDadosFornecedor implements IStrategy {

	public String processar(EntidadeDominio entidade) {

		Fornecedor fornecedor = (Fornecedor)entidade;
		
		String cnpj = fornecedor.getCnpj();
		String rzSocial = fornecedor.getRzSocial();
		String nmFantasia = fornecedor.getNmFantasia();
		String  inscricaoEstadual = fornecedor.getInscricaoEstadual();
		String inscricaoMunicipal = fornecedor.getInscricaoMunicipal();
		String email = fornecedor.getEmail();
		
		if(cnpj == null || cnpj == "")
			return "CNPJ obrigatório \n>";
		
		if(rzSocial == null || rzSocial == "")
			return "Razão Social obrigatória \n";
		
		if(nmFantasia == null || nmFantasia == "")
			return "Nome fantasia obrigatório \n";
		
		if(inscricaoEstadual == null || inscricaoEstadual == "")
			return "Inscrição estadual obrigatória \n";
		
		if(inscricaoMunicipal == null || inscricaoMunicipal == "")
			return "Inscrição municipal obrigatória \n";
		
		if(email == null || email == "")
			return "Email obrigatório \n";
		
	
		return null;			
	}
	
}
