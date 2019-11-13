package br.com.integrador.fut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.integrador.fut.model.Endereco;
import br.com.integrador.fut.persistencia.EnderecoDAO;

@Controller
@RequestMapping(path = "/endereco/")
public class EnderecoController {

	private EnderecoDAO eDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco) {
		eDAO = new EnderecoDAO();
		endereco = (Endereco) eDAO.cadastrar(endereco);
		return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);

	}

	@RequestMapping(value = "listar/", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> listaTodosEnderecos() {

		eDAO = new EnderecoDAO();
		List<Object> listaEnderecos = eDAO.buscarTodos();
		return new ResponseEntity<List<Object>>(listaEnderecos, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Endereco endereco) {
		eDAO = new EnderecoDAO();
		eDAO.editar(endereco);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		eDAO = new EnderecoDAO();
		eDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> buscarPorId(@PathVariable long id) {
		eDAO = new EnderecoDAO();
		Endereco endereco = (Endereco) eDAO.buscarPorId(id);
		if (endereco != null) {
			return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
		}
		return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
	}
}
