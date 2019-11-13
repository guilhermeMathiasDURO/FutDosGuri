package com.example.fut.model;

public class Jogador {

    private long idJogador;
    private String nomeJogador;
    private int idadeJogador;
    private String emailJogador;
    private String senhaJogador;
    private int camisaJogador;
    private String numJogador;

    public Jogador() { }

    public Jogador(long idJogador, String nomeJogador, int idadeJogador, String emailJogador, String senhaJogador,
                   int camisaJogador, String numJogador) {
        super();
        this.idJogador = idJogador;
        this.nomeJogador = nomeJogador;
        this.idadeJogador = idadeJogador;
        this.emailJogador = emailJogador;
        this.senhaJogador = senhaJogador;
        this.camisaJogador = camisaJogador;
        this.numJogador = numJogador;
    }

    public long getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(long idJogador) {
        this.idJogador = idJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getIdadeJogador() {
        return idadeJogador;
    }

    public void setIdadeJogador(int idadeJogador) {
        this.idadeJogador = idadeJogador;
    }

    public String getEmailJogador() {
        return emailJogador;
    }

    public void setEmailJogador(String emailJogador) {
        this.emailJogador = emailJogador;
    }

    public String getSenhaJogador() {
        return senhaJogador;
    }

    public void setSenhaJogador(String senhaJogador) {
        this.senhaJogador = senhaJogador;
    }

    public int getCamisaJogador() {
        return camisaJogador;
    }

    public void setCamisaJogador(int camisaJogador) {
        this.camisaJogador = camisaJogador;
    }

    public String getNumJogador() {
        return numJogador;
    }

    public void setNumJogador(String numJogador) {
        this.numJogador = numJogador;
    }
}