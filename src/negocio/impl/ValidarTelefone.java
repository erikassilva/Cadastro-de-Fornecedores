package negocio.impl;

import dominio.EntidadeDominio;
import dominio.Fornecedor;
import negocio.IStrategy;

public class ValidarTelefone implements IStrategy {
	
	public String processar(EntidadeDominio entidade) {
	
		String verificarTelefone = new String();
		Fornecedor fornecedor = (Fornecedor)entidade;

        for (int i = 0; i<fornecedor.getTelefones().size(); i++) {
			String ddi = fornecedor.getTelefones().get(i).getDdi();
        	String ddd = fornecedor.getTelefones().get(i).getDdd();
        	String numero = fornecedor.getTelefones().get(i).getNumero();

			if(ddi == null || ddi == ""){
			 	verificarTelefone += "DDI Telefone obrigatório(s)\n";
		 	}

			if(ddd == null || ddd == ""){
				verificarTelefone += "DDD Telefone obrigatório(s)\n";
		 	}
			 
			if(numero == null || numero == ""){
				verificarTelefone += "Numero Telefone obrigatório(s)\n";
		 	}

			if(verificarTelefone != ""){
				return verificarTelefone;
			}
        }

		return null;
	}

}
