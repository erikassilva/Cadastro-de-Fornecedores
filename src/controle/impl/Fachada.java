package controle.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controle.IFachada;
import dao.IDAO;
import dao.impl.FornecedorDAO;
import negocio.IStrategy;
import negocio.impl.ValidarCnae;
import negocio.impl.ValidarCnpj;
import negocio.impl.ValidarContaBancaria;
import negocio.impl.ValidarContato;
import negocio.impl.ValidarDadosFornecedor;
import negocio.impl.ValidarEndereco;
import negocio.impl.ValidarFornecimento;
import negocio.impl.ValidarTelefone;
import negocio.impl.ValidarUnicidadeCnpj;
import dominio.EntidadeDominio;
import dominio.Fornecedor;

public class Fachada implements IFachada {
	
	/* Mapa de daos indexado pelo nome da classe e tem como valor um DAO */	
	private Map<String, IDAO> daos = new HashMap<String, IDAO>();
	
	/* Mapa de regras de negocio indexado pelo nome da classe e tem como valor uma lista de strategies */	
	private Map<String, List<IStrategy>> rns = new HashMap<String, List<IStrategy>>();
	
	public Fachada(){
		String nmFornecedor = Fornecedor.class.getName();
		daos.put(nmFornecedor, new FornecedorDAO());
				
		ValidarCnae vCnae = new ValidarCnae();
		ValidarCnpj vCnpj = new ValidarCnpj();
		ValidarContaBancaria vContaBancaria = new ValidarContaBancaria();
		ValidarContato vContato = new ValidarContato();
		ValidarDadosFornecedor vDadosFornecedor = new ValidarDadosFornecedor();
		ValidarEndereco vEndereco = new ValidarEndereco();
		ValidarFornecimento vFornecimento = new ValidarFornecimento();
		ValidarTelefone vTelefone = new ValidarTelefone();
		ValidarUnicidadeCnpj vUnicidadeCnpj = new ValidarUnicidadeCnpj();
					
		ArrayList<IStrategy> rnsFornecedor = new ArrayList<IStrategy>();
		rnsFornecedor.add(vCnae);
		rnsFornecedor.add(vCnpj);
		rnsFornecedor.add(vContaBancaria);
		rnsFornecedor.add(vContato);
		rnsFornecedor.add(vDadosFornecedor);
		rnsFornecedor.add(vEndereco);
		rnsFornecedor.add(vFornecimento);
		rnsFornecedor.add(vTelefone);
		rnsFornecedor.add(vUnicidadeCnpj);
		
		rns.put(nmFornecedor, rnsFornecedor);
		
	}
	
	public String salvar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		String nmEntidade = entidade.getClass().getName();
		List<IStrategy> regras = rns.get(nmEntidade);
		
		for(IStrategy s: regras){
			String msg = s.processar(entidade);
			if(msg != null){
				sb.append(msg);
				sb.append("\n");
			}
		}
		
		if(sb.length() == 0){
			IDAO dao = daos.get(nmEntidade);
			dao.salvar(entidade);
		}else{
			return sb.toString();
		}
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
