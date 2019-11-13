package br.com.integrador.fut.testes;

import java.util.List;

import br.com.integrador.fut.model.Jogador;
import br.com.integrador.fut.persistencia.JogadorDAO;

public class TesteJogador {
	public static void main(String[] args) {
		
// CADASTRAR JOGADOR
		
//		Jogador jogador = new Jogador();	
//		jogador.setNomeJogador("Renanzinho Salsa Grilo Metamorfo");
//		jogador.setIdadeJogador(17);
//		jogador.setEmailJogador("renan.grilo@gmail.com");
//		jogador.setSenhaJogador("futebolneymars2");
//		jogador.setCamisaJogador(10);
//		jogador.setNumJogador("051 999999999");
//		
//		JogadorDAO jDAO = new JogadorDAO();
//		
//		jDAO.cadastrar(jogador);
		
// EDITAR JOGADOR
		
//		Jogador jogador = new Jogador();	
//		jogador.setNomeJogador("Renanzinho Salsa Grilo Metamorfo");
//		jogador.setIdadeJogador(17);
//		jogador.setEmailJogador("renan.meta@gmail.com");
//		jogador.setSenhaJogador("futebolneymars2");
//		jogador.setCamisaJogador(10);
//		jogador.setNumJogador("051 999999990");
//		jogador.setIdJogador(2);
//		
//		JogadorDAO jDAO = new JogadorDAO();
//		jDAO.editar(jogador);
		
// EXCLUIR JOGADOR 
		
//		JogadorDAO jDAO = new JogadorDAO();
//		jDAO.excluir(1);
		
// BUSCAR POR ID JOGADOR
		
//		JogadorDAO jDAO = new JogadorDAO();
//		Jogador jogador = (Jogador) jDAO.buscarPorId(2);
//		System.out.println("Jogador buscado por ID: " + jogador.getNomeJogador());
	
// BUSCAR TODOS JOGADOR
	
		JogadorDAO jDAO = new JogadorDAO();
		List<Object> listaJogadores = jDAO.buscarTodos();
		System.out.println("Lista de jogadores: ");
		for(int i = 0; i < listaJogadores.size(); i++) {
			System.out.println(((Jogador) listaJogadores.get(i)).getNomeJogador());
		}
	}
}
