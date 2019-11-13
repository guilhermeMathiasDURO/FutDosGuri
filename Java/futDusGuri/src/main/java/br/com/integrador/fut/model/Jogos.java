package br.com.integrador.fut.model;

public class Jogos {

	private long idJogos;
	private String placar;
	private String horario;
	private String gols;
	private Ginasio ginasio;
	
	public Jogos() {
		
	}

	public Jogos(long idJogos, String placar, String horario, String gols, Ginasio ginasio) {
		super();
		this.idJogos = idJogos;
		this.placar = placar;
		this.horario = horario;
		this.gols = gols;
		this.ginasio = ginasio;
	}

	public long getIdJogos() {
		return idJogos;
	}

	public void setIdJogos(long idJogos) {
		this.idJogos = idJogos;
	}

	public String getPlacar() {
		return placar;
	}

	public void setPlacar(String placar) {
		this.placar = placar;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getGols() {
		return gols;
	}

	public void setGols(String gols) {
		this.gols = gols;
	}

	public Ginasio getGinasio() {
		return ginasio;
	}

	public void setGinasio(Ginasio ginasio) {
		this.ginasio = ginasio;
	}
}
