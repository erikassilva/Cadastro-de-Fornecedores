package dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.IDAO;
import dominio.Cidade;
import dominio.Cnae;
import dominio.ContaBancaria;
import dominio.Contato;
import dominio.Departamento;
import dominio.Empresa;
import dominio.Endereco;
import dominio.Fornecedor;
import dominio.Os;
import dominio.Pais;
import dominio.Pessoa;
import dominio.Produto;
import dominio.Servico;
import dominio.Telefone;
import dominio.TipoEndereco;
import dominio.TipoLogradouro;
import dominio.Uf;

public class TesteDAO {
	
	public static void main(String[] args) {
		

		List<Contato> listaContatos = new ArrayList<>();
        List<Cnae> listaCnaes = new ArrayList<>();
        List<Produto> listaProdutos = new ArrayList<>();
        List<Servico> listaServicos = new ArrayList<>();
        List<Telefone> listaTelefones = new ArrayList<Telefone>();
        List<ContaBancaria> contasBancarias = new ArrayList<ContaBancaria>();
        //List<Empresa> empresas;
    	List<Os> listaOrdens = new ArrayList<Os>(); ;
    	
			
		Pais p1 = new Pais("Brasil");
		Uf sp = new Uf ("SP", "SP", p1);
		Cidade mogi = new Cidade("Mogi das Cruzes", sp);
		TipoLogradouro tl = new TipoLogradouro("Rua", "RuaCata");
		TipoEndereco te = new TipoEndereco("Tipo", "Assim");
		Endereco endereco = new Endereco("Rua da Fatec", "00000000", "xxxx", "saudade", mogi, tl, te);
		endereco.setDtCadastro(new Date());	
				
		Cnae cna1 = new Cnae("123");
        
		Pessoa pes1 = new Pessoa("erika");
		Departamento dep1 = new Departamento("finance");
		Contato con1 = new Contato("erika", "@eeeai", dep1);
		
        Telefone tel1 = new Telefone("11", "11", "1");
        
        Os os1 = new Os(1/1/2022);
        Produto pro1 = new Produto("parafuso", "3 pinos");
        Servico ser1 = new Servico("assistencia");             		
               
		Fornecedor erika = new Fornecedor("@asd", "1000", "12345678996", "123456", "afasda", "asdasfd", "asda", "123", endereco);			
		erika.setDtCadastro(new Date());
		
		listaContatos.add(con1);
        listaCnaes.add(cna1);
        listaProdutos.add(pro1);
        listaServicos.add(ser1);
        listaTelefones.add(tel1);
        listaOrdens.add(os1);
        erika.setContatos(listaContatos);
        erika.setCnaes(listaCnaes);
        erika.setProdutos(listaProdutos);
        erika.setServicos(listaServicos);
        erika.setStatus("Ativo");
        erika.setTelefones(listaTelefones);
        erika.setOrdemServicos(listaOrdens);
        //command.executar(erika);
		
		IDAO daoEnd = new FornecedorDAO();
						
		daoEnd.salvar(erika);
		
	}

	
}