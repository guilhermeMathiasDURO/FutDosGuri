package br.com.integrador.fut.testes;

import java.util.List;

import br.com.integrador.fut.model.Clube;
import br.com.integrador.fut.persistencia.ClubeDAO;

public class TesteClube {
	public static void main(String[] args) {
		
// CADASTRAR CLUBE
		
//		Clube clube = new Clube();	
//		clube.setNomeClube("Fut dus Guri");
//		clube.setQntdJogador(20);
//		clube.setCnpjClube("98.947.098/0001-93");
//		clube.setNumClube("051 999999999");
//		clube.setTecnico("Renan Salsa");
//		
//		ClubeDAO cDAO = new ClubeDAO();
//		
//		cDAO.cadastrar(clube);
		
// EDITAR CLUBE
		
//		Clube clube = new Clube();	
//		clube.setNomeClube("Fut dus Guri");
//		clube.setQntdJogador(20);
//		clube.setCnpjClube("98.947.098/0001-93");
//		clube.setNumClube("051 999999999");
//		clube.setTecnico("Renan Grilo");
//		clube.setIdClube(1);
//		
//		ClubeDAO cDAO = new ClubeDAO();
//		cDAO.editar(clube);
		
// EXCLUIR CLUBE 
		
//		ClubeDAO cDAO = new ClubeDAO();
//		cDAO.excluir(1);
		
// BUSCAR POR ID CLUBE
		
//		ClubeDAO cDAO = new ClubeDAO();
//		Clube clube = (Clube) cDAO.buscarPorId(4);
//		System.out.println("Clube buscado por ID: " + clube.getNomeClube());
	
// BUSCAR TODOS CLUBE
	
		ClubeDAO cDAO = new ClubeDAO();
		List<Object> listaClube = cDAO.buscarTodos();
		System.out.println("Lista de clubes: ");
		for(int i = 0; i < listaClube.size(); i++) {
			System.out.println(((Clube) listaClube.get(i)).getNomeClube());
		}
	}
}
