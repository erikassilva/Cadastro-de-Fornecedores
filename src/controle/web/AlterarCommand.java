package controle.web;

import dominio.EntidadeDominio;

public class AlterarCommand extends AbstractCommand {
	
	public Object executar(EntidadeDominio entidade) {
		return fachada.alterar(entidade);
	}

}
