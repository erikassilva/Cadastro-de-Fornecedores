package negocio.impl;

import dominio.EntidadeDominio;
import negocio.IStrategy;

public abstract class AbstractValidator
	
	implements IStrategy {
		protected StringBuilder sb = new StringBuilder();
	
		protected boolean isNull(Object obj) {
			if(obj == null || obj.toString().trim() == "") 
				return true;
			return false;
		}
	}
