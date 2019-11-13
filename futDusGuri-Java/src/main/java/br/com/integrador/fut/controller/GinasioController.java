package br.com.integrador.fut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.integrador.fut.model.Ginasio;
import br.com.integrador.fut.persistencia.GinasioDAO;

@Controller
@RequestMapping(path = "/ginasio/")
public class GinasioController {

	private GinasioDAO gDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Ginasio> cadastrar(@RequestBody Ginasio ginasio) {
		gDAO = new GinasioDAO();
		ginasio = (Ginasio) gDAO.cadastrar(ginasio);
		return new ResponseEntity<Ginasio>(ginasio, HttpStatus.CREATED);

	}

	@RequestMapping(value = "listar/", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> listaTodosGinasios() {

		gDAO = new GinasioDAO();
		List<Object> listaGinasios = gDAO.buscarTodos();
		return new ResponseEntity<List<Object>>(listaGinasios, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Ginasio ginasio) {
		gDAO = new GinasioDAO();
		gDAO.editar(ginasio);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		gDAO = new GinasioDAO();
		gDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Ginasio> buscarPorId(@PathVariable long id) {
		gDAO = new GinasioDAO();
		Ginasio ginasio = (Ginasio) gDAO.buscarPorId(id);
		if (ginasio != null) {
			return new ResponseEntity<Ginasio>(ginasio, HttpStatus.OK);
		}
		return new ResponseEntity<Ginasio>(HttpStatus.NOT_FOUND);
	}
}
