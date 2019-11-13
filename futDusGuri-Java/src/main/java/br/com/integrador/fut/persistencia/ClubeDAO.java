package br.com.integrador.fut.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.integrador.fut.model.Clube;

public class ClubeDAO implements ObrigatorioDAO {

	private ConexaoMysql conexao;

	public ClubeDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "fut");
	}

	// CADASTRAR
	public Object cadastrar(Object objeto) {
		
		Clube clube = (Clube) objeto;

		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO clube VALUES(null, ?, ?, ?, ?, ?);";
		try {

			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, clube.getNomeClube());
			statement.setInt(2, clube.getQntdJogador());
			statement.setString(3, clube.getCnpjClube());
			statement.setString(4, clube.getNumClube());
			statement.setString(5, clube.getTecnico());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			
			if (rs.next()) {
				clube.setIdClube(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return clube;
	}

	// EDITAR
	public void editar(Object objeto) {

		Clube clube = (Clube) objeto;
		
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE clube SET nome_clube=?, qntd_jogador=?, cnpj_clube=?, num_clube=?, tecnico=? WHERE id_clube=?;";
		
		try {
			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			
			statement.setString(1, clube.getNomeClube());
			statement.setInt(2, clube.getQntdJogador());
			statement.setString(3, clube.getCnpjClube());
			statement.setString(4, clube.getNumClube());
			statement.setString(5, clube.getTecnico());
			statement.setLong(6, clube.getIdClube());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	// EXCLUIR
	public void excluir(long id) {
		
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM clube WHERE id_clube=?;";
		
		try {
			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, id);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	// BUSCAR TODOS
	public List<Object> buscarTodos() {
		
		this.conexao.abrirConexao();
		String sqlSelect = "SELECT * FROM clube;";
		PreparedStatement statement;
		Clube clube = null;
		List<Object> listaClubes = new ArrayList<Object>();
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				clube = new Clube();
				clube.setIdClube(rs.getLong("id_clube"));
				clube.setNomeClube(rs.getString("nome_clube"));
				clube.setQntdJogador(rs.getInt("qntd_jogador"));
				clube.setCnpjClube(rs.getString("cnpj_clube"));
				clube.setNumClube(rs.getString("num_clube"));
				clube.setTecnico(rs.getString("tecnico"));

				listaClubes.add(clube);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaClubes;
	}

	//BUSCAR POR ID
	public Object buscarPorId(long id) {
		
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM clube WHERE id_clube=?;";
		PreparedStatement statement;
		Clube clube = null;
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {

				clube = new Clube();
				clube.setIdClube(rs.getLong("id_clube"));
				clube.setNomeClube(rs.getString("nome_clube"));
				clube.setQntdJogador(rs.getInt("qntd_jogador"));
				clube.setCnpjClube(rs.getString("cnpj_clube"));
				clube.setNumClube(rs.getString("num_clube"));
				clube.setTecnico(rs.getString("tecnico"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return clube;
	}
}