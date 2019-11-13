package br.com.integrador.futdosguri.model;

public class ClubeJogos {

    private long idClubeJogos;
    private Clube clube;
    private Jogos jogos;

    public ClubeJogos() { }

    public ClubeJogos(long idClubeJogos, Clube clube, Jogos jogos) {
        super();
        this.idClubeJogos = idClubeJogos;
        this.clube = clube;
        this.jogos = jogos;
    }

    public long getIdClubeJogos() {
        return idClubeJogos;
    }

    public void setIdClubeJogos(long idClubeJogos) {
        this.idClubeJogos = idClubeJogos;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }

    public Jogos getJogos() {
        return jogos;
    }

    public void setJogos(Jogos jogos) {
        this.jogos = jogos;
    }
}