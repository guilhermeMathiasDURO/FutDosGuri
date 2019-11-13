package br.com.integrador.fut.testes;

import java.util.List;

import br.com.integrador.fut.model.Ginasio;
import br.com.integrador.fut.model.Jogos;
import br.com.integrador.fut.persistencia.JogosDAO;

public class TesteJogos {
	public static void main(String[] args) {
		
// CADASTRAR JOGOS
		
		Ginasio ginasio = new Ginasio();
		ginasio.setIdGinasio(3);
//		
//		Jogos jogos = new Jogos();	
//		jogos.setPlacar("3-2");
//		jogos.setHorario("2019-10-26 14:00:00");
//		jogos.setGols("1, 2, 3 - Renan Grilo");
//		
//		JogosDAO jDAO = new JogosDAO();
//		jogos.setGinasio(ginasio);
//		jDAO.cadastrar(jogos);
		
// EDITAR JOGOS
		
//		Ginasio ginasio = new Ginasio();
//		ginasio.setIdGinasio(2);
		
//		Jogos jogos = new Jogos();	
//		jogos.setPlacar("1-2");
//		jogos.setHorario("2019-10-26 13:00:00");
//		jogos.setGols("1, 2, 3 - Renan Salsa");
//		jogos.setIdJogos(1);
//		
//		JogosDAO jDAO = new JogosDAO();
//		jogos.setGinasio(ginasio);
//		jDAO.editar(jogos);
		
// EXCLUIR JOGOS 
		
//		JogosDAO jDAO = new JogosDAO();
//		jDAO.excluir(1);
		
// BUSCAR POR ID JOGOS
		
//		JogosDAO jDAO = new JogosDAO();
//		Jogos jogos = (Jogos) jDAO.buscarPorId(2);
//		System.out.println("Jogos buscado por ID: " + jogos.getGols());
	
// BUSCAR TODOS JOGOS
	
		JogosDAO jDAO = new JogosDAO();
		List<Object> listaJogos = jDAO.buscarTodos();
		System.out.println("Lista de jogos: ");
		for(int i = 0; i < listaJogos.size(); i++) {
			System.out.println(((Jogos) listaJogos.get(i)).getGols());
		}
	}
}
