package negocio.impl;

import dominio.EntidadeDominio;
import dominio.Fornecedor;
import negocio.IStrategy;

public class ValidarCnpj implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		
		Fornecedor fornecedor = (Fornecedor)entidade;
		String cnpj = fornecedor.getCnpj().replace("-", "").replace(".", "").replace("/", "");
				
		if(cnpj == null || cnpj.length()!=14){
			return "O CNPJ dever ter pelo menos 14 digitos!<br/>";
		}else {
			return null;
		}
	}
}
