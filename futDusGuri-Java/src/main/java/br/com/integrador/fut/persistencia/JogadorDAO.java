package br.com.integrador.fut.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.integrador.fut.model.Jogador;

public class JogadorDAO implements ObrigatorioDAO {

	private ConexaoMysql conexao;

	public JogadorDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "fut");
	}

	// CADASTRAR
	public Object cadastrar(Object objeto) {
		
		Jogador jogador = (Jogador) objeto;

		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO jogador VALUES(null, ?, ?, ?, ?, ?, ?);";
		try {

			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, jogador.getNomeJogador());
			statement.setInt(2, jogador.getIdadeJogador());
			statement.setString(3, jogador.getEmailJogador());
			statement.setString(4, jogador.getSenhaJogador());
			statement.setInt(5, jogador.getCamisaJogador());
			statement.setString(6, jogador.getNumJogador());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			
			if (rs.next()) {
				jogador.setIdJogador(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return jogador;
	}

	// EDITAR
	public void editar(Object objeto) {

		Jogador jogador = (Jogador) objeto;
		
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE jogador SET nome_jogador=?, idade_jogador=?, email_jogador=?, senha_jogador=?, camisa_jogador=?, num_jogador=? WHERE id_jogador=?;";
		
		try {
			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);

			statement.setString(1, jogador.getNomeJogador());
			statement.setInt(2, jogador.getIdadeJogador());
			statement.setString(3, jogador.getEmailJogador());
			statement.setString(4, jogador.getSenhaJogador());
			statement.setInt(5, jogador.getCamisaJogador());
			statement.setString(6, jogador.getNumJogador());
			statement.setLong(7, jogador.getIdJogador());
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
		String sqlDelete = "DELETE FROM jogador WHERE id_jogador=?;";
		
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
		String sqlSelect = "SELECT * FROM jogador;";
		PreparedStatement statement;
		Jogador jogador = null;
		List<Object> listaJogadores = new ArrayList<Object>();
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				jogador = new Jogador();
				jogador.setIdJogador(rs.getLong("id_jogador"));
				jogador.setNomeJogador(rs.getString("nome_jogador"));
				jogador.setIdadeJogador(rs.getInt("idade_jogador"));
				jogador.setEmailJogador(rs.getString("email_jogador"));
				jogador.setSenhaJogador(rs.getString("senha_jogador"));
				jogador.setCamisaJogador(rs.getInt("camisa_jogador"));
				jogador.setNumJogador(rs.getString("num_jogador"));

				listaJogadores.add(jogador);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaJogadores;
	}

	//BUSCAR POR ID
	public Object buscarPorId(long id) {
		
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM jogador WHERE id_jogador=?;";
		PreparedStatement statement;
		Jogador jogador = null;
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {

				jogador = new Jogador();
				jogador.setIdJogador(rs.getLong("id_jogador"));
				jogador.setNomeJogador(rs.getString("nome_jogador"));
				jogador.setIdadeJogador(rs.getInt("idade_jogador"));
				jogador.setEmailJogador(rs.getString("email_jogador"));
				jogador.setSenhaJogador(rs.getString("senha_jogador"));
				jogador.setCamisaJogador(rs.getInt("camisa_jogador"));
				jogador.setNumJogador(rs.getString("num_jogador"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return jogador;
	}
}