package negocio.impl;

import dominio.Cidade;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Fornecedor;
import dominio.TipoEndereco;
import dominio.TipoLogradouro;
import negocio.IStrategy;

public class ValidarEndereco implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		
		Fornecedor fornecedor = (Fornecedor)entidade;
		String cep = fornecedor.getEndereco().getCep();
		String logradouro = fornecedor.getEndereco().getLogradouro();
		String numero = fornecedor.getEndereco().getNumero();
		String bairro = fornecedor.getEndereco().getBairro();
		//String complemento = fornecedor.getEndereco().getComplemento();
		//Cidade cidade = fornecedor.getEndereco().getCidade();
		//TipoLogradouro tipoLogradouro = fornecedor.getEndereco().getTipoLogradouro(); 
		//TipoEndereco tipoEndereco = fornecedor.getEndereco().getTipoEndereco();
		
		if ( cep  == null || cep.isBlank())
			return "CEP obrigatório \n";
		
		if ( logradouro  == null || logradouro.isBlank())
			return "Logradouro obrigatório \n";
		
		if ( numero  == null || numero.isBlank())
			return "Número obrigatório \n";
		
		if ( bairro  == null || bairro.isBlank())
			return "Bairro obrigatório \n";
		
		//if ( cidade  == null || cidade.isBlank())
		//	return "Cidade obrigatória \n";
		
		//if ( tipoLogradouro  == null || tipoLogradouro.isBlank())
		//	return "Tipo Logradouro obrigatório \n";
		
		//if ( tipoEndereco  == null || tipoEndereco.isBlank())
		//	return "Tipo Endereço obrigatório \n";
		
		
		return null;
	}

}
