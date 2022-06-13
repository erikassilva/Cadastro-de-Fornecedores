package negocio.impl;

import dominio.EntidadeDominio;
import dominio.Fornecedor;
import negocio.IStrategy;

public class ValidarContaBancaria implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		
		String verificarConta = new String();
		Fornecedor fornecedor = (Fornecedor)entidade;

        for (int i = 0; i<fornecedor.getContasBancarias().size(); i++) {
			String banco = fornecedor.getContasBancarias().get(i).getBanco();
        	String agencia = fornecedor.getContasBancarias().get(i).getAgencia();
        	String conta = fornecedor.getContasBancarias().get(i).getConta();

			if(banco == null || banco == ""){
			 	verificarConta += "Banco obrigatório(s)\n";
		 	}

			if(agencia == null || agencia == ""){
				verificarConta += "Agência obrigatória(s)\n";
		 	}
			 
			if(conta == null || conta == ""){
				verificarConta += "Numero da conta obrigatório(s)\n";
		 	}

			if(verificarConta != ""){
				return verificarConta;
			}
        }

		return null;
	}

}
