package controle.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controle.IFachada;
import dao.IDAO;
import dao.impl.FornecedorDAO;
import dominio.EntidadeDominio;
import dominio.Fornecedor;
import negocio.IStrategy;
import negocio.impl.ValidarCnae;
import negocio.impl.ValidarCnpj;
import negocio.impl.ValidarContaBancaria;
import negocio.impl.ValidarContato;
import negocio.impl.ValidarDadosFornecedor;
import negocio.impl.ValidarEndereco;
import negocio.impl.ValidarFornecimento;
import negocio.impl.ValidarTelefone;

public class Fachada implements IFachada {
	
	/* Mapa de daos indexado pelo nome da classe 
	 * e tem como valor um DAO */	
	private Map<String, IDAO> daos = new HashMap<String, IDAO>();
	
	/* Mapa de regras de negocio indexado pelo nome da classe 
	 * e tem como valor uma lista de strategies */	
	private Map<String, List<IStrategy>> rns = new HashMap<String, List<IStrategy>>();
	
	@Override
	public String salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
		

}
