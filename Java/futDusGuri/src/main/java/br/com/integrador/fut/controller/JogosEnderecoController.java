package br.com.integrador.fut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.integrador.fut.model.JogosEndereco;
import br.com.integrador.fut.persistencia.JogosEnderecoDAO;

@Controller
@RequestMapping(path = "/jogosEndereco/")
public class JogosEnderecoController {

	private JogosEnderecoDAO jeDAO;

	@RequestMapping(value = "", method = RequestMethod.POST)

	public ResponseEntity<JogosEndereco> cadastrar(@RequestBody JogosEndereco jogosEndereco) {
		jeDAO = new JogosEnderecoDAO();
		jogosEndereco = (JogosEndereco) jeDAO.cadastrar(jogosEndereco);
		return new ResponseEntity<JogosEndereco>(jogosEndereco, HttpStatus.CREATED);

	}

	@RequestMapping(value = "listar/", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> listaTodosJogosEnderecos() {

		jeDAO = new JogosEnderecoDAO();
		List<Object> listaJogosEnderecos = jeDAO.buscarTodos();
		return new ResponseEntity<List<Object>>(listaJogosEnderecos, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody JogosEndereco jogosEndereco) {
		jeDAO = new JogosEnderecoDAO();
		jeDAO.editar(jogosEndereco);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		jeDAO = new JogosEnderecoDAO();
		jeDAO.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<JogosEndereco> buscarPorId(@PathVariable long id) {
		jeDAO = new JogosEnderecoDAO();
		JogosEndereco jogosEndereco = (JogosEndereco) jeDAO.buscarPorId(id);
		if (jogosEndereco != null) {
			return new ResponseEntity<JogosEndereco>(jogosEndereco, HttpStatus.OK);
		}
		return new ResponseEntity<JogosEndereco>(HttpStatus.NOT_FOUND);
	}
}
