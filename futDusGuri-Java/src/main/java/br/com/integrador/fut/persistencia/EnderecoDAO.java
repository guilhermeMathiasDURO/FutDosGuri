package br.com.integrador.fut.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.integrador.fut.model.Clube;
import br.com.integrador.fut.model.Endereco;
import br.com.integrador.fut.model.Ginasio;
import br.com.integrador.fut.model.Jogador;

public class EnderecoDAO implements ObrigatorioDAO {

	private ConexaoMysql conexao;

	public EnderecoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "fut");
	}

	// CADASTRAR
	public Object cadastrar(Object objeto) {
		
		Endereco endereco = (Endereco) objeto;
		
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO endereco VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, endereco.getCep());
			statement.setString(2, endereco.getEstado());
			statement.setString(3, endereco.getCidade());
			statement.setString(4, endereco.getBairro());
			statement.setString(5, endereco.getRua());
			statement.setInt(6, endereco.getNumero());
			statement.setLong(7, endereco.getJogador().getIdJogador());
			statement.setLong(8, endereco.getGinasio().getIdGinasio());
			statement.setLong(9, endereco.getClube().getIdClube());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			
			if (rs.next()) {
				endereco.setIdEndereco(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return endereco;
	}
	
	// EDITAR
	public void editar(Object objeto) {

		Endereco endereco = (Endereco) objeto;
		
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE endereco SET cep=?, estado=?, cidade=?, bairro=?, rua=?, numero=?, id_jogador=?, id_ginasio=?, id_clube=? WHERE id_endereco=?;";

		try {
			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);

			statement.setString(1, endereco.getCep());
			statement.setString(2, endereco.getEstado());
			statement.setString(3, endereco.getCidade());
			statement.setString(4, endereco.getBairro());
			statement.setString(5, endereco.getRua());
			statement.setInt(6, endereco.getNumero());
			statement.setLong(7, endereco.getJogador().getIdJogador());
			statement.setLong(8, endereco.getGinasio().getIdGinasio());
			statement.setLong(9, endereco.getClube().getIdClube());
			statement.setLong(10, endereco.getIdEndereco());

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
		String sqlDelete = "DELETE FROM endereco WHERE id_endereco=?;";
		
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
		String sqlSelect = "SELECT * FROM endereco e INNER JOIN jogador j ON e.id_jogador = j.id_jogador INNER JOIN ginasio g ON e.id_ginasio = g.id_ginasio INNER JOIN clube c ON e.id_clube = c.id_clube;";
		PreparedStatement statement;
		Endereco endereco = null;
		List<Object> listaEnderecos = new ArrayList<Object>();
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				endereco = new Endereco();
				endereco.setIdEndereco(rs.getLong("id_endereco"));
				endereco.setCep(rs.getString("cep"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));

				Jogador jogador = new Jogador();
				
				jogador.setIdJogador(rs.getLong("id_jogador"));
				jogador.setNomeJogador(rs.getString("nome_jogador"));
				jogador.setIdadeJogador(rs.getInt("idade_jogador"));
				jogador.setEmailJogador(rs.getString("email_jogador"));
				jogador.setSenhaJogador(rs.getString("senha_jogador"));
				jogador.setCamisaJogador(rs.getInt("camisa_jogador"));
				jogador.setNumJogador(rs.getString("num_jogador"));
				
				Ginasio ginasio = new Ginasio();
				
				ginasio.setIdGinasio(rs.getLong("id_ginasio"));
				ginasio.setCnpjGinasio(rs.getString("cnpj_ginasio"));
				ginasio.setHorariosLivres(rs.getString("horarios_livres"));
				ginasio.setNumGinasio(rs.getString("num_ginasio"));
				
				Clube clube = new Clube();
				
				clube.setIdClube(rs.getLong("id_clube"));
				clube.setNomeClube(rs.getString("nome_clube"));
				clube.setQntdJogador(rs.getInt("qntd_jogador"));
				clube.setCnpjClube(rs.getString("cnpj_clube"));
				clube.setNumClube(rs.getString("num_clube"));
				clube.setTecnico(rs.getString("tecnico"));
				
				endereco.setJogador(jogador);
				endereco.setGinasio(ginasio);
				endereco.setClube(clube);
				listaEnderecos.add(endereco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaEnderecos;
	}

	// BUSCAR POR ID
	public Object buscarPorId(long id) {
		
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM endereco e INNER JOIN jogador j ON e.id_jogador = j.id_jogador INNER JOIN ginasio g ON e.id_ginasio = g.id_ginasio INNER JOIN clube c ON e.id_clube = c.id_clube WHERE id_endereco=?;";
		PreparedStatement statement;
		Endereco endereco = null;
		
		try {
			
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				endereco = new Endereco();
				endereco.setIdEndereco(rs.getLong("id_endereco"));
				endereco.setCep(rs.getString("cep"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));

				Jogador jogador = new Jogador();
				
				jogador.setIdJogador(rs.getLong("id_jogador"));
				jogador.setNomeJogador(rs.getString("nome_jogador"));
				jogador.setIdadeJogador(rs.getInt("idade_jogador"));
				jogador.setEmailJogador(rs.getString("email_jogador"));
				jogador.setSenhaJogador(rs.getString("senha_jogador"));
				jogador.setCamisaJogador(rs.getInt("camisa_jogador"));
				jogador.setNumJogador(rs.getString("num_jogador"));
				
				Ginasio ginasio = new Ginasio();
				
				ginasio.setIdGinasio(rs.getLong("id_ginasio"));
				ginasio.setCnpjGinasio(rs.getString("cnpj_ginasio"));
				ginasio.setHorariosLivres(rs.getString("horarios_livres"));
				ginasio.setNumGinasio(rs.getString("num_ginasio"));
				
				Clube clube = new Clube();
				
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
		return endereco;
	}
}