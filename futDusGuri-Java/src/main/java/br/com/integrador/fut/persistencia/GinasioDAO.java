package br.com.integrador.fut.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.integrador.fut.model.Ginasio;

public class GinasioDAO implements ObrigatorioDAO {

	private ConexaoMysql conexao;

	public GinasioDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "fut");
	}

	// CADASTRAR
	public Object cadastrar(Object objeto) {
		
		Ginasio ginasio = (Ginasio) objeto;

		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO ginasio VALUES(null, ?, ?, ?);";
		try {

			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, ginasio.getCnpjGinasio());
			statement.setString(2, ginasio.getHorariosLivres());
			statement.setString(3, ginasio.getNumGinasio());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			
			if (rs.next()) {
				ginasio.setIdGinasio(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return ginasio;
	}

	// EDITAR
	public void editar(Object objeto) {

		Ginasio ginasio = (Ginasio) objeto;
		
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE ginasio SET cnpj_ginasio=?, horarios_livres=?, num_ginasio=? WHERE id_ginasio=?;";
		
		try {
			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			
			statement.setString(1, ginasio.getCnpjGinasio());
			statement.setString(2, ginasio.getHorariosLivres());
			statement.setString(3, ginasio.getNumGinasio());
			statement.setLong(4, ginasio.getIdGinasio());
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
		String sqlDelete = "DELETE FROM ginasio WHERE id_ginasio=?;";
		
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
		String sqlSelect = "SELECT * FROM ginasio;";
		PreparedStatement statement;
		Ginasio ginasio = null;
		List<Object> listaGinasios = new ArrayList<Object>();
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				ginasio = new Ginasio();
				ginasio.setIdGinasio(rs.getLong("id_ginasio"));
				ginasio.setCnpjGinasio(rs.getString("cnpj_ginasio"));
				ginasio.setHorariosLivres(rs.getString("horarios_livres"));
				ginasio.setNumGinasio(rs.getString("num_ginasio"));

				listaGinasios.add(ginasio);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaGinasios;
	}

	//BUSCAR POR ID
	public Object buscarPorId(long id) {
		
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM ginasio WHERE id_ginasio=?;";
		PreparedStatement statement;
		Ginasio ginasio = null;
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {

				ginasio = new Ginasio();
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
		return ginasio;
	}
}