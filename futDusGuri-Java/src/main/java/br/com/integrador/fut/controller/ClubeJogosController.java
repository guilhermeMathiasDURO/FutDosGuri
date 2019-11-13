package br.com.integrador.fut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.integrador.fut.model.ClubeJogos;
import br.com.integrador.fut.persistencia.ClubeDAO;

@Controller
@RequestMapping(path = "/clubeJogos/")
public class ClubeJogosController {

	private ClubeDAO cjDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<ClubeJogos> cadastrar(@RequestBody ClubeJogos clubeJogos) {
		cjDAO = new ClubeDAO();
		clubeJogos = (ClubeJogos) cjDAO.cadastrar(clubeJogos);
		return new ResponseEntity<ClubeJogos>(clubeJogos, HttpStatus.CREATED);

	}

	@RequestMapping(value = "listar/", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> listaTodosClubeJogos() {

		cjDAO = new ClubeDAO();
		List<Object> listaClubes = cjDAO.buscarTodos();
		return new ResponseEntity<List<Object>>(listaClubes, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ClubeJogos clubeJogos) {
		cjDAO = new ClubeDAO();
		cjDAO.editar(clubeJogos);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		cjDAO = new ClubeDAO();
		cjDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<ClubeJogos> buscarPorId(@PathVariable long id) {
		cjDAO = new ClubeDAO();
		ClubeJogos clubeJogos = (ClubeJogos) cjDAO.buscarPorId(id);
		if (clubeJogos != null) {
			return new ResponseEntity<ClubeJogos>(clubeJogos, HttpStatus.OK);
		}
		return new ResponseEntity<ClubeJogos>(HttpStatus.NOT_FOUND);
	}
}
