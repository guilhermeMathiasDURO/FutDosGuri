package br.com.integrador.fut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.integrador.fut.model.Jogos;
import br.com.integrador.fut.persistencia.JogosDAO;

@Controller
@RequestMapping(path = "/jogos/")
public class JogosController {

	private JogosDAO jDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Jogos> cadastrar(@RequestBody Jogos jogos) {
		jDAO = new JogosDAO();
		jogos = (Jogos) jDAO.cadastrar(jogos);
		return new ResponseEntity<Jogos>(jogos, HttpStatus.CREATED);

	}

	@RequestMapping(value = "listar/", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> listaTodosJogoss() {

		jDAO = new JogosDAO();
		List<Object> listaJogos = jDAO.buscarTodos();
		return new ResponseEntity<List<Object>>(listaJogos, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Jogos jogos) {
		jDAO = new JogosDAO();
		jDAO.editar(jogos);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		jDAO = new JogosDAO();
		jDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Jogos> buscarPorId(@PathVariable long id) {
		jDAO = new JogosDAO();
		Jogos jogos = (Jogos) jDAO.buscarPorId(id);
		if (jogos != null) {
			return new ResponseEntity<Jogos>(jogos, HttpStatus.OK);
		}
		return new ResponseEntity<Jogos>(HttpStatus.NOT_FOUND);
	}
}
