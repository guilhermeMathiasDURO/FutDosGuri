package br.com.integrador.fut.persistencia;

import java.sql.PreparedStatement;    
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.integrador.fut.model.Clube;
import br.com.integrador.fut.model.ClubeJogos;
import br.com.integrador.fut.model.Jogos;


public class ClubeJogosDAO {
	
	private ConexaoMysql conexao;
	
	public ClubeJogosDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "fut");
	}
	
	// CADASTRAR
	public ClubeJogos cadastrar(ClubeJogos clubeJogos) {
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "INSERT INTO clube_jogos VALUES(null, ?, ?);";
		try {
			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

			statement.setLong(1, clubeJogos.getClube().getIdClube());
			statement.setLong(2, clubeJogos.getJogos().getIdJogos());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			
			if(rs.next()){
				clubeJogos.setIdClubeJogos(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return clubeJogos;
	}
	
	// EDITAR
	public void editar(ClubeJogos clubeJogos) {

		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE clube_jogos SET id_clube=?, id_jogos=? WHERE id_clube_jogos=?;";
		try {
			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			
			statement.setLong(1, clubeJogos.getClube().getIdClube());
			statement.setLong(2, clubeJogos.getJogos().getIdJogos());
			statement.setLong(3, clubeJogos.getIdClubeJogos());
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

		String sqlDelete = "DELETE FROM clube_jogos WHERE id_clube_jogos=?;";

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
	public List<ClubeJogos> buscarTodos() {

		this.conexao.abrirConexao();

		String sqlSelect = "SELECT * FROM clube_jogos cj INNER JOIN clube c ON cj.id_clube = c.id_clube INNER JOIN jogos j ON cj.id_jogos = j.id_jogos;";
		PreparedStatement statement;
		ClubeJogos clubeJogos = null;
		List<ClubeJogos> listaClubeJogos = new ArrayList<ClubeJogos>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {

				clubeJogos = new ClubeJogos();
				clubeJogos.setIdClubeJogos(rs.getLong("id_clube_jogos"));
				
				Clube clube = new Clube();
				clube = new Clube();
				clube.setIdClube(rs.getLong("id_clube"));
				clube.setNomeClube(rs.getString("nome_clube"));
				clube.setQntdJogador(rs.getInt("qntd_jogador"));
				clube.setCnpjClube(rs.getString("cnpj_clube"));
				clube.setNumClube(rs.getString("num_clube"));
				clube.setTecnico(rs.getString("tecnico"));

				
				Jogos jogos = new Jogos();
				jogos.setIdJogos(rs.getLong("id_jogos"));
				jogos.setPlacar(rs.getString("placar"));
				jogos.setHorario(rs.getString("horario"));
				jogos.setGols(rs.getString("gols"));
				
				clubeJogos.setClube(clube);
				clubeJogos.setJogos(jogos);
				listaClubeJogos.add(clubeJogos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaClubeJogos;
	}

	// BUSCAR POR ID
	public ClubeJogos buscarPorId(long id) {

		this.conexao.abrirConexao();

		String sqlInsert = "SELECT * FROM clube_jogos cj INNER JOIN clube c ON cj.id_clube = c.id_clube INNER JOIN jogos j ON cj.id_jogos = j.id_jogos WHERE id_clube_jogos=?;";
		PreparedStatement statement;
		ClubeJogos clubeJogos = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {

				clubeJogos = new ClubeJogos();
				clubeJogos.setIdClubeJogos(rs.getLong("id_clube_jogos"));
					
				Clube clube = new Clube();
				clube = new Clube();
				clube.setIdClube(rs.getLong("id_clube"));
				clube.setNomeClube(rs.getString("nome_clube"));
				clube.setQntdJogador(rs.getInt("qntd_jogador"));
				clube.setCnpjClube(rs.getString("cnpj_clube"));
				clube.setNumClube(rs.getString("num_clube"));
				clube.setTecnico(rs.getString("tecnico"));

				
				Jogos jogos = new Jogos();
				jogos.setIdJogos(rs.getLong("id_jogos"));
				jogos.setPlacar(rs.getString("placar"));
				jogos.setHorario(rs.getString("horario"));
				jogos.setGols(rs.getString("gols"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return clubeJogos;
	}	
}