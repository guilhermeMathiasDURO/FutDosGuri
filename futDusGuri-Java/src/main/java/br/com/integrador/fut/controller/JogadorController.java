package br.com.integrador.fut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.integrador.fut.model.Jogador;
import br.com.integrador.fut.persistencia.JogadorDAO;

@Controller
@RequestMapping(path = "/jogador/")
public class JogadorController {

	private JogadorDAO jDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Jogador> cadastrar(@RequestBody Jogador jogador) {
		jDAO = new JogadorDAO();
		jogador = (Jogador) jDAO.cadastrar(jogador);
		return new ResponseEntity<Jogador>(jogador, HttpStatus.CREATED);

	}

	@RequestMapping(value = "listar/", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> listaTodosJogadors() {

		jDAO = new JogadorDAO();
		List<Object> listaJogadors = jDAO.buscarTodos();
		return new ResponseEntity<List<Object>>(listaJogadors, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Jogador jogador) {
		jDAO = new JogadorDAO();
		jDAO.editar(jogador);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		jDAO = new JogadorDAO();
		jDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Jogador> buscarPorId(@PathVariable long id) {
		jDAO = new JogadorDAO();
		Jogador jogador = (Jogador) jDAO.buscarPorId(id);
		if (jogador != null) {
			return new ResponseEntity<Jogador>(jogador, HttpStatus.OK);
		}
		return new ResponseEntity<Jogador>(HttpStatus.NOT_FOUND);
	}
}
