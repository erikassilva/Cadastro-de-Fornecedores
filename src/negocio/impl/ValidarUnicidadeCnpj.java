package negocio.impl;

import java.util.List;

import dao.IDAO;
import dao.impl.FornecedorDAO;
import dominio.EntidadeDominio;
import dominio.Fornecedor;
import negocio.IStrategy;


public class ValidarUnicidadeCnpj implements IStrategy {

	public String processar(EntidadeDominio entidade) {
	
		IDAO fornecedorDao = new FornecedorDAO();
		
		List<EntidadeDominio> fornecedores = fornecedorDao.consultar(entidade);
		
		if(fornecedores != null && fornecedores.size() > 0){
			return "Fornecedor já cadastrado!";
		}
		
		return null;
	}
}
