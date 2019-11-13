package br.com.integrador.fut.persistencia;

import java.sql.PreparedStatement;    
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.integrador.fut.model.Endereco;
import br.com.integrador.fut.model.Jogos;
import br.com.integrador.fut.model.JogosEndereco;


public class JogosEnderecoDAO {
	
	private ConexaoMysql conexao;
	
	public JogosEnderecoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "fut");
	}
	
	// CADASTRAR
	public JogosEndereco cadastrar(JogosEndereco jogosEndereco) {
			
		this.conexao.abrirConexao();
		
		String sqlInsert = "INSERT INTO jogos_endereco VALUES(null, ?, ?);";
		try {

			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

			statement.setLong(1, jogosEndereco.getEndereco().getIdEndereco());
			statement.setLong(2, jogosEndereco.getJogos().getIdJogos());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()){
				jogosEndereco.setIdJogosEndereco(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return jogosEndereco;
	}

	// EDITAR
	public void editar(JogosEndereco jogosEndereco) {

		this.conexao.abrirConexao();

		String sqlUpdate = "UPDATE jogos_endereco SET id_endereco=?, id_jogos=? WHERE id_jogos_endereco=?;";
		try {

			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			
			statement.setLong(1, jogosEndereco.getEndereco().getIdEndereco());
			statement.setLong(2, jogosEndereco.getJogos().getIdJogos());
			statement.setLong(3, jogosEndereco.getIdJogosEndereco());
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

		String sqlDelete = "DELETE FROM jogos_endereco WHERE id_jogos_endereco=?;";
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
	
		String sqlSelect = "SELECT * FROM jogos_endereco je INNER JOIN endereco e ON je.id_endereco = e.id_endereco INNER JOIN jogos j ON cj.id_jogos = j.id_jogos;";
		PreparedStatement statement;
		JogosEndereco jogosEndereco = null;
		List<Object> listaJogosEndereco = new ArrayList<Object>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
	
				jogosEndereco = new JogosEndereco();
				jogosEndereco.setIdJogosEndereco(rs.getLong("id_jogos_endereco"));
				
				Endereco endereco = new Endereco();
				
				endereco.setIdEndereco(rs.getLong("id_endereco"));
				endereco.setCep(rs.getString("cep"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));

				
				Jogos jogos = new Jogos();
				
				jogos.setIdJogos(rs.getLong("id_jogos"));
				jogos.setPlacar(rs.getString("placar"));
				jogos.setHorario(rs.getString("horario"));
				jogos.setGols(rs.getString("gols"));
				
				jogosEndereco.setEndereco(endereco);
				jogosEndereco.setJogos(jogos);
				listaJogosEndereco.add(jogosEndereco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaJogosEndereco;
	}

	// BUSCAR POR ID
	public JogosEndereco buscarPorId(long id) {
		// ABRIR A CONEXAO COM O BANCO
		this.conexao.abrirConexao();
		// SQL COM A OPERACAO QUE DESEJA-SE REALIZAR
		String sqlInsert = "SELECT * FROM jogos_endereco je INNER JOIN endereco e ON je.id_endereco = e.id_endereco INNER JOIN jogos j ON cj.id_jogos = j.id_jogos WHERE id_jogos_endereco=?;";
		PreparedStatement statement;
		JogosEndereco jogosEndereco = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				// Converter um objeto ResultSet em um objeto JogosEndereco
				jogosEndereco = new JogosEndereco();
				jogosEndereco.setIdJogosEndereco(rs.getLong("id_jogos_endereco"));
				
				Endereco endereco = new Endereco();
				
				endereco.setIdEndereco(rs.getLong("id_endereco"));
				endereco.setCep(rs.getString("cep"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));;

				
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
		return jogosEndereco;
	}	
}