package br.com.integrador.fut.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.integrador.fut.model.Ginasio;
import br.com.integrador.fut.model.Jogos;

public class JogosDAO implements ObrigatorioDAO {

	private ConexaoMysql conexao;

	public JogosDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "fut");
	}

	// CADASTRAR
	public Object cadastrar(Object objeto) {
		
		Jogos jogos = (Jogos) objeto;

		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO jogos VALUES(null, ?, ?, ?, ?);";
		try {

			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, jogos.getPlacar());
			statement.setString(2, jogos.getHorario());
			statement.setString(3, jogos.getGols());
			statement.setLong(4, jogos.getGinasio().getIdGinasio());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			
			if (rs.next()) {
				jogos.setIdJogos(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return jogos;
	}

	// EDITAR
	public void editar(Object objeto) {

		Jogos jogos = (Jogos) objeto;
		
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE jogos SET placar=?, horario=?, gols=?, id_ginasio=? WHERE id_jogos=?;";
		
		try {
			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			
			statement.setString(1, jogos.getPlacar());
			statement.setString(2, jogos.getHorario());
			statement.setString(3, jogos.getGols());
			statement.setLong(4, jogos.getGinasio().getIdGinasio());
			statement.setLong(5, jogos.getIdJogos());
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
		String sqlDelete = "DELETE FROM jogos WHERE id_jogos=?;";
		
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
		String sqlSelect = "SELECT * FROM jogos j INNER JOIN ginasio g ON j.id_ginasio = g.id_ginasio;";
		PreparedStatement statement;
		Jogos jogos = null;
		List<Object> listaJogoss = new ArrayList<Object>();
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				jogos = new Jogos();
				jogos.setIdJogos(rs.getLong("id_jogos"));
				jogos.setPlacar(rs.getString("placar"));
				jogos.setHorario(rs.getString("horario"));
				jogos.setGols(rs.getString("gols"));
				
				Ginasio ginasio = new Ginasio();
				ginasio.setIdGinasio(rs.getLong("id_ginasio"));
				ginasio.setCnpjGinasio(rs.getString("cnpj_ginasio"));
				ginasio.setHorariosLivres(rs.getString("horarios_livres"));
				ginasio.setNumGinasio(rs.getString("num_ginasio"));

				listaJogoss.add(jogos);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaJogoss;
	}

	//BUSCAR POR ID
	public Object buscarPorId(long id) {
		
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM jogos j INNER JOIN ginasio g ON j.id_ginasio = g.id_ginasio WHERE id_jogos=?;";
		PreparedStatement statement;
		Jogos jogos = null;
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {

				jogos = new Jogos();
				jogos.setIdJogos(rs.getLong("id_jogos"));
				jogos.setPlacar(rs.getString("placar"));
				jogos.setHorario(rs.getString("horario"));
				jogos.setGols(rs.getString("gols"));
				
				Ginasio ginasio = new Ginasio();
				ginasio.setIdGinasio(rs.getLong("id_ginasio"));
				ginasio.setCnpjGinasio(rs.getString("cnpj_ginasio"));
				ginasio.setHorariosLivres(rs.getString("horarios_livres"));
				ginasio.setNumGinasio(rs.getString("num_ginasio"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return jogos;
	}
}