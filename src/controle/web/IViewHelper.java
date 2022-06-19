package controle.web;

import dominio.EntidadeDominio;
import javax.servlet;

public interface IViewHelper {
	
	public EntidadeDominio getEntidade(HttpServletRequest request);
	public void setEntidade(HttpServletResponse response, HttpServletRequest request,
			Object msg);

}
