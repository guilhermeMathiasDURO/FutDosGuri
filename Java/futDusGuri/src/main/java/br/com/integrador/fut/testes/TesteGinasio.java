package br.com.integrador.fut.testes;

import java.util.List;

import br.com.integrador.fut.model.Ginasio;
import br.com.integrador.fut.persistencia.GinasioDAO;

public class TesteGinasio {
	public static void main(String[] args) {
		
// CADASTRAR GINASIO
		
//		Ginasio ginasio = new Ginasio();	
//		ginasio.setCnpjGinasio("37.035.109/0001-74");
//		ginasio.setHorariosLivres("2019-10-28 13:00:00");
//		ginasio.setNumGinasio("051 999999999");
//		
//		GinasioDAO gDAO = new GinasioDAO();
//		
//		gDAO.cadastrar(ginasio);
		
// EDITAR GINASIO
		
//		Ginasio ginasio = new Ginasio();	
//		ginasio.setCnpjGinasio("37.035.109/0001-74");
//		ginasio.setHorariosLivres("2019-10-28 13:00:00");
//		ginasio.setNumGinasio("051 999999998");
//		ginasio.setIdGinasio(1);
//		
//		GinasioDAO gDAO = new GinasioDAO();
//		gDAO.editar(ginasio);
		
// EXCLUIR GINASIO 
		
//		GinasioDAO gDAO = new GinasioDAO();
//		gDAO.excluir(1);
		
// BUSCAR POR ID GINASIO
		
//		GinasioDAO gDAO = new GinasioDAO();
//		Ginasio ginasio = (Ginasio) gDAO.buscarPorId(2);
//		System.out.println("Ginasio buscado por ID: " + ginasio.getCnpjGinasio());
	
// BUSCAR TODOS GINASIO
	
		GinasioDAO gDAO = new GinasioDAO();
		List<Object> listaGinasio = gDAO.buscarTodos();
		System.out.println("Lista de ginásios: ");
		for(int i = 0; i < listaGinasio.size(); i++) {
			System.out.println(((Ginasio) listaGinasio.get(i)).getCnpjGinasio());
		}
	}
}
