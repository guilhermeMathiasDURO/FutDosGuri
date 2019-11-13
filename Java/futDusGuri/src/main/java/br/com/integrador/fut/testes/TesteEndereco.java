package br.com.integrador.fut.testes;

import java.util.List;

import br.com.integrador.fut.model.Jogador;
import br.com.integrador.fut.model.Ginasio;
import br.com.integrador.fut.model.Clube;
import br.com.integrador.fut.model.Endereco;
import br.com.integrador.fut.persistencia.EnderecoDAO;

public class TesteEndereco {
	public static void main(String[] args) {
		
// CADASTRAR ENDERECO
		
		
		//só não tá comentado pra não ficar amarelinho
		Jogador jogador = new Jogador();
		jogador.setIdJogador(2);
		
		Ginasio ginasio = new Ginasio();
		ginasio.setIdGinasio(2);
		
		Clube clube = new Clube();
		clube.setIdClube(4);
//		
//		Endereco endereco = new Endereco();		
//		endereco.setCep("79074-050");
//		endereco.setEstado("MS");
//		endereco.setCidade("Campo Grande");
//		endereco.setBairro("Jardim Monte Alegre");
//		endereco.setRua("Rua Padre Julião Urquiza");
//		endereco.setNumero(465);
//		
//		EnderecoDAO eDAO = new EnderecoDAO();
//		
//		endereco.setJogador(jogador);
//		endereco.setGinasio(ginasio);
//		endereco.setClube(clube);
//		eDAO.cadastrar(endereco);
		
// EDITAR ENDEREÇO
		
//		Jogador jogador = new Jogador();
//		jogador.setIdJogador(2);
//		
//		Ginasio ginasio = new Ginasio();
//		ginasio.setIdGinasio(2);
//		
//		Clube clube = new Clube();
//		clube.setIdClube(4);
//		
//		Endereco endereco = new Endereco();		
//		endereco.setCep("79074-051");
//		endereco.setEstado("MS");
//		endereco.setCidade("Campo Grande");
//		endereco.setBairro("Jardim Monte Alegre");
//		endereco.setRua("Rua Padre Julião Urquiza");
//		endereco.setNumero(465);
//		endereco.setIdEndereco(2);
//		
//		EnderecoDAO eDAO = new EnderecoDAO();
//		
//		endereco.setJogador(jogador);
//		endereco.setGinasio(ginasio);
//		endereco.setClube(clube);
//		eDAO.editar(endereco);
		
// EXCLUIR ENDEREÇO 
		
//		EnderecoDAO eDAO = new EnderecoDAO();
//		eDAO.excluir(2);
		
// BUSCAR POR ID ENDEREÇO
		
//		EnderecoDAO eDAO = new EnderecoDAO();
//		Endereco endereco = (Endereco) eDAO.buscarPorId(2);
//		System.out.println("Endereço buscado por ID: " + endereco.getRua());

// BUSCAR TODOS ENDEREÇO
	
		EnderecoDAO eDAO = new EnderecoDAO();
		List<Object> listaEndereco = eDAO.buscarTodos();
		System.out.println("Lista de endereços: ");
		for(int i = 0; i < listaEndereco.size(); i++) {
			System.out.println(((Endereco) listaEndereco.get(i)).getRua());
		}
	}
}
