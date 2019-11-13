package br.com.integrador.fut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.integrador.fut.model.Clube;
import br.com.integrador.fut.persistencia.ClubeDAO;

@Controller
@RequestMapping(path = "/clube/")
public class ClubeController {

	private ClubeDAO cDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Clube> cadastrar(@RequestBody Clube clube) {
		cDAO = new ClubeDAO();
		clube = (Clube) cDAO.cadastrar(clube);
		return new ResponseEntity<Clube>(clube, HttpStatus.CREATED);

	}

	@RequestMapping(value = "listar/", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> listaTodosClubes() {

		cDAO = new ClubeDAO();
		List<Object> listaClubes = cDAO.buscarTodos();
		return new ResponseEntity<List<Object>>(listaClubes, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Clube clube) {
		cDAO = new ClubeDAO();
		cDAO.editar(clube);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		cDAO = new ClubeDAO();
		cDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Clube> buscarPorId(@PathVariable long id) {
		cDAO = new ClubeDAO();
		Clube clube = (Clube) cDAO.buscarPorId(id);
		if (clube != null) {
			return new ResponseEntity<Clube>(clube, HttpStatus.OK);
		}
		return new ResponseEntity<Clube>(HttpStatus.NOT_FOUND);
	}
}
