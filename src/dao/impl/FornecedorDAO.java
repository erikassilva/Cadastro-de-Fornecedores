package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import dao.IDAO;
import dominio.Cnae;
import dominio.ContaBancaria;
import dominio.Contato;
import dominio.Empresa;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Fornecedor;
import dominio.Os;
import dominio.Produto;
import dominio.Servico;
import dominio.Telefone;

public class FornecedorDAO implements IDAO {

	private Connection connection = null;
	
	public void salvar(EntidadeDominio entidade) {
		
		PreparedStatement pst = null;
		Fornecedor fornecedor = (Fornecedor)entidade;
		
				
		try {
			connection = Conexao.getConnectionPostgres();
			connection.setAutoCommit(false);
			
			EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
			enderecoDAO.salvar(fornecedor.getEndereco());
						
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_fornecedor(email, cnpj, inscricao_estadual, inscricao_municipal, razao_social, nome_fantasia, status, tipo_fornecimento, ");
			sql.append("end_id, dt_cadastro) VALUES (?,?,?,?,?,?,?,?,?,?) ");
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, fornecedor.getEmail());
			pst.setString(2, fornecedor.getCnpj());
			pst.setString(3, fornecedor.getInscricaoEstadual());
			pst.setString(4, fornecedor.getInscricaoMunicipal());
			pst.setString(5, fornecedor.getRzSocial());
			pst.setString(6, fornecedor.getNmFantasia());
			pst.setString(7, fornecedor.getStatus());
			pst.setString(8, fornecedor.getTipoFornecimento());
			pst.setInt(9, fornecedor.getEndereco().getId());
			Timestamp time = new Timestamp(fornecedor.getDtCadastro().getTime());
			pst.setTimestamp(10, time);
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int idFor = 0;
			if(rs.next())
				idFor = rs.getInt(1);
			fornecedor.setId(idFor);
			
			salvarOSs(fornecedor);
			salvarServicos(fornecedor);
			salvarProdutos(fornecedor);
			salvarContas(fornecedor);
			salvarTelefones(fornecedor);
			salvarCnaes(fornecedor);
			salvarContatos(fornecedor);
			
			connection.commit();
		}catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void salvarCnaes(Fornecedor fornecedor) throws SQLException {
		PreparedStatement pst = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_cnae(numero, ");
		sql.append("dt_cadastro) ");
		sql.append(" VALUES (?,?) ");

		for (Cnae cn : fornecedor.getCnaes()) {
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, cn.getNumero());
			Timestamp time = new Timestamp(cn.getDtCadastro().getTime());
			pst.setTimestamp(2, time);
			
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idCna = 0;
			if (rs.next())
				idCna = rs.getInt(1);
			cn.setId(idCna);

		}
	}

	private void salvarTelefones(Fornecedor fornecedor) throws SQLException {
		
		PreparedStatement pst = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_telefone(ddd, ddi, ");
		sql.append("numero, tipoTelefone, dt_cadastro) ");
		sql.append(" VALUES (?, ?, ?, ?, ?)");	
	
		for (Telefone t : fornecedor.getTelefones()) {
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, t.getDdd());
			pst.setString(2, t.getDdi());
			pst.setString(3, t.getNumero());
			pst.setString(4, t.getTipoTelefone().getDescricao());
				
			Timestamp time = new Timestamp(t.getDtCadastro().getTime());
			pst.setTimestamp(5, time);
			
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idTel = 0;
			if (rs.next())
				idTel = rs.getInt(1);
			t.setId(idTel);

		}
	}


	private void salvarContas(Fornecedor fornecedor) throws SQLException {
		
		PreparedStatement pst = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_contas(banco, agencia, ");
		sql.append("conta, dt_cadastro) ");
		sql.append(" VALUES (?, ?, ?, ?)");	
	
		for (ContaBancaria cb : fornecedor.getContasBancarias()) {
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, cb.getBanco());
			pst.setString(2, cb.getAgencia());
			pst.setString(3, cb.getConta());
				
			Timestamp time = new Timestamp(cb.getDtCadastro().getTime());
			pst.setTimestamp(4, time);
			
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idCon = 0;
			if (rs.next())
				idCon = rs.getInt(1);
			cb.setId(idCon);

		}
	}

	private void salvarProdutos(Fornecedor fornecedor) throws SQLException {
		
		PreparedStatement pst = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_produto(nome, descricao, ");
		sql.append("dt_cadastro) ");
		sql.append(" VALUES (?, ?, ?)");
		
		for (Produto prod : fornecedor.getProdutos()) {
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, prod.getNome());
			pst.setString(2, prod.getDescricao());
			
			Timestamp time = new Timestamp(prod.getDtCadastro().getTime());
			pst.setTimestamp(3, time);
			
			pst.executeUpdate();		

			ResultSet rs = pst.getGeneratedKeys();
			int idPro = 0;
			if (rs.next())
				idPro = rs.getInt(1);
			prod.setId(idPro);

		}
	}

	private void salvarServicos(Fornecedor fornecedor) throws SQLException {
		
		PreparedStatement pst = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_servico(descricao, ");
		sql.append("dt_cadastro) ");
		sql.append(" VALUES (?, ?)");
		
		for (Servico s : fornecedor.getServicos()) {
			
			pst.setString(1, s.getDescricao());		
			
			Timestamp time = new Timestamp(s.getDtCadastro().getTime());
			pst.setTimestamp(2, time);
			
			pst.executeUpdate();		

			ResultSet rs = pst.getGeneratedKeys();
			int idSer = 0;
			if (rs.next())
				idSer = rs.getInt(1);
			s.setId(idSer);

		}

	}

	private void salvarOSs(Fornecedor fornecedor) throws SQLException {
		
		PreparedStatement pst = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_os(dt_inicio, os_for_id, ");
		sql.append("dt_cadastro) VALUES (?,?,?)");

		for (Os o : fornecedor.getOrdemServicos()) {
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			pst.setLong(1, o.getDtInicio());
			pst.setInt(2, fornecedor.getId());
			Timestamp time = new Timestamp(fornecedor.getDtCadastro().getTime());
			pst.setTimestamp(3, time);

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idOs = 0;
			if (rs.next())
				idOs = rs.getInt(1);
			o.setId(idOs);

		}

	}

	private void salvarContatos(Fornecedor fornecedor) throws SQLException {
		
		PreparedStatement pst = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_contato(email, departamento, ");
		sql.append("dt_cadastro) ");
		sql.append(" VALUES (?, ?, ?)");	

		for (Contato c : fornecedor.getContatos()) {
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, c.getEmail());
			pst.setString(2, c.getDepartamento().getDescricao());			
			
			Timestamp time = new Timestamp(c.getDtCadastro().getTime());
			pst.setTimestamp(3, time);
			
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idCont = 0;
			if (rs.next())
				idCont = rs.getInt(1);
			c.setId(idCont);

		}

	}

	

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
