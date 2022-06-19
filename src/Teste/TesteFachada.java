package Teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.IDAO;
import controle.IFachada;
import controle.impl.Fachada;
import dao.impl.FornecedorDAO;
import dominio.Cidade;
import dominio.Cnae;
import dominio.ContaBancaria;
import dominio.Contato;
import dominio.Departamento;
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
import dominio.TipoTelefone;
import dominio.Uf;

public class TesteFachada {
	
	public static void main(String[] args) {
		
		List<Contato> listaContatos = new ArrayList<>();
        List<Cnae> listaCnaes = new ArrayList<>();
        List<Produto> listaProdutos = new ArrayList<>();
        List<Servico> listaServicos = new ArrayList<>();
        List<Telefone> listaTelefones = new ArrayList<Telefone>();
        List<ContaBancaria> listaContasBancarias = new ArrayList<ContaBancaria>();
    	List<Os> listaOrdens = new ArrayList<Os>();
    	
			
		Pais p1 = new Pais("Brasil");
		Uf sp = new Uf ("SP", "SP", p1);
		Cidade mogi = new Cidade("Mogi das Cruzes", sp);
		TipoLogradouro tl = new TipoLogradouro("Rua", "RuaCata");
		TipoEndereco te = new TipoEndereco("Tipo", "Assim");
		Endereco endereco = new Endereco("Rua da Fatec", "00000000", "xxxx", "saudade", mogi, tl, te);
		endereco.setDtCadastro(new Date());	
				
		Cnae cna1 = new Cnae("123");
		cna1.setDtCadastro(new Date());
		
		Pessoa pes1 = new Pessoa("erika");
		Departamento dep1 = new Departamento("finance");
		Contato con1 = new Contato("erika", "@eeeai", dep1);
		con1.setDtCadastro(new Date());
		dep1.setDtCadastro(new Date());
		pes1.setDtCadastro(new Date());
		
		TipoTelefone tp1 = new TipoTelefone("Celular");
        Telefone tel1 = new Telefone("11", "11", "1", tp1);
        tel1.setDtCadastro(new Date());
        
        Os os1 = new Os(1/1/2022);
        Produto pro1 = new Produto("parafuso", "3 pinos");
        Servico ser1 = new Servico("assistencia");
        pro1.setDtCadastro(new Date());
        ser1.setDtCadastro(new Date());
        
        ContaBancaria cb1 = new ContaBancaria("Bradesco", "203", "123456");
        cb1.setDtCadastro(new Date());
        
		Fornecedor erika = new Fornecedor("@erika", "10007539512538", "12345678996", "123456", "afasda", "asdasfd", "asda", "123", endereco);			
		erika.setDtCadastro(new Date());
		
		listaContatos.add(con1);
        listaCnaes.add(cna1);
        listaProdutos.add(pro1);
        listaServicos.add(ser1);
        listaTelefones.add(tel1);
        listaOrdens.add(os1);
        listaContasBancarias.add(cb1);
        erika.setContatos(listaContatos);
        erika.setCnaes(listaCnaes);
        erika.setProdutos(listaProdutos);
        erika.setServicos(listaServicos);
        erika.setStatus("Ativo");
        erika.setTelefones(listaTelefones);
        erika.setOrdemServicos(listaOrdens);
        erika.setContasBancarias(listaContasBancarias);
        
        IFachada fachada = new Fachada();
		
		String msg = fachada.salvar(erika);
		
		
		if(msg != null)
			System.out.println(msg);
		
		
	}

}
