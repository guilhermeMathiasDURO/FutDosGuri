package br.com.integrador.fut.model;

public class JogosEndereco {
	
	private long idJogosEndereco;
	private Endereco endereco;
	private Jogos jogos;
	
	public JogosEndereco() {
		
	}

	public JogosEndereco(long idJogosEndereco, Endereco endereco, Jogos jogos) {
		super();
		this.idJogosEndereco = idJogosEndereco;
		this.endereco = endereco;
		this.jogos = jogos;
	}

	public long getIdJogosEndereco() {
		return idJogosEndereco;
	}

	public void setIdJogosEndereco(long idJogosEndereco) {
		this.idJogosEndereco = idJogosEndereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Jogos getJogos() {
		return jogos;
	}

	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}
}
