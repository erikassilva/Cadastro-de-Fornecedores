package dao.impl;

import java.util.Date;
import java.util.List;

import dao.IDAO;
import dominio.Cidade;
import dominio.Cnae;
import dominio.ContaBancaria;
import dominio.Contato;
import dominio.Empresa;
import dominio.Endereco;
import dominio.Fornecedor;
import dominio.Os;
import dominio.Pais;
import dominio.Produto;
import dominio.Servico;
import dominio.Telefone;
import dominio.TipoEndereco;
import dominio.TipoLogradouro;
import dominio.Uf;

public class TesteDAO {
	
	public static void main(String[] args) {
			
		Pais p1 = new Pais("Brasil");
		Uf sp = new Uf ("SP", "SP", p1);
		Cidade mogi = new Cidade("Mogi das Cruzes", sp);
		TipoLogradouro tl = new TipoLogradouro("Rua", "RuaCata");
		TipoEndereco te = new TipoEndereco("Tipo", "Assim");
		
		Endereco endereco = new Endereco("Rua da Fatec", "00000000", "xxxx", "saudade", mogi, tl, te);
		endereco.setDtCadastro(new Date());	
		
		
		
		Fornecedor fornecedor = new Fornecedor("@asd", "1000", "12345678996", "123456", "afasda", "asdasfd", "asda", "123", endereco);			
		fornecedor.setDtCadastro(new Date());
		
		IDAO daoEnd = new FornecedorDAO();
		
		daoEnd.salvar(fornecedor);
	}

	
}