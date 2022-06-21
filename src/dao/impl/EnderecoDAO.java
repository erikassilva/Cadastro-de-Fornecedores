package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import dao.IDAO;
import dominio.Cidade;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Fornecedor;
import dominio.TipoEndereco;
import dominio.TipoLogradouro;

public class EnderecoDAO implements IDAO {
	
	private Connection connection;
	private boolean ctrlTransaction = true;
	
	public EnderecoDAO() {}
	
	public EnderecoDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		
		PreparedStatement pst = null;
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tb_endereco(cep, numero, bairro, cidade, estado, logradouro, tipo_logradouro, tipo_endereco, dt_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
		try {
			if (connection == null) {
				connection = Conexao.getConnectionPostgres();
			}else {
				ctrlTransaction = false;
			}
			
			connection.setAutoCommit(false);
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, end.getCep());
			pst.setString(2, end.getNumero());
			pst.setString(3, end.getBairro());
			pst.setString(4, end.getCidade().getDescricao());
			pst.setString(5, end.getCidade().getUf().getDescricao());
			pst.setString(6, end.getLogradouro());
			pst.setString(7, end.getTipoLogradouro().getNome());
			pst.setString(8, end.getTipoEndereco().getNome());
			pst.setTimestamp(9, new Timestamp(end.getDtCadastro().getTime()));
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			if (ctrlTransaction) {
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		
		PreparedStatement pst = null;
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE SET tb_endereco(cep=?, numero=?, bairro=?, cidade=?, estado=?, logradouro=?, tipo_logradouro=?, tipo_endereco=?");
		sql.append("WHERE for_id=?;");
			
		try {
			if (connection == null) {
				connection = Conexao.getConnectionPostgres();
			}else {
				ctrlTransaction = false;
			}
			
			connection.setAutoCommit(false);
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, end.getCep());
			pst.setString(2, end.getNumero());
			pst.setString(3, end.getBairro());
			pst.setString(4, end.getCidade().getDescricao());
			pst.setString(5, end.getCidade().getUf().getDescricao());
			pst.setString(6, end.getLogradouro());
			pst.setString(7, end.getTipoLogradouro().getNome());
			pst.setString(8, end.getTipoEndereco().getNome());
			pst.setInt(9, end.getId());
			
			pst.executeUpdate();
						
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			if (ctrlTransaction) {
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return null;
		
	}

}
