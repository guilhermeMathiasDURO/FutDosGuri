package com.example.fut.model;

public class Clube {

    private long idClube;
    private String nomeClube;
    private int qntdJogador;
    private String cnpjClube;
    private String numClube;
    private String tecnico;

    public Clube() { }

    public Clube(long idClube, String nomeClube, int qntdJogador, String cnpjClube, String numClube, String tecnico) {
        super();
        this.idClube = idClube;
        this.nomeClube = nomeClube;
        this.qntdJogador = qntdJogador;
        this.cnpjClube = cnpjClube;
        this.numClube = numClube;
        this.tecnico = tecnico;
    }

    public long getIdClube() {
        return idClube;
    }

    public void setIdClube(long idClube) {
        this.idClube = idClube;
    }

    public String getNomeClube() {
        return nomeClube;
    }

    public void setNomeClube(String nomeClube) {
        this.nomeClube = nomeClube;
    }

    public int getQntdJogador() {
        return qntdJogador;
    }

    public void setQntdJogador(int qntdJogador) {
        this.qntdJogador = qntdJogador;
    }

    public String getCnpjClube() {
        return cnpjClube;
    }

    public void setCnpjClube(String cnpjClube) {
        this.cnpjClube = cnpjClube;
    }

    public String getNumClube() {
        return numClube;
    }

    public void setNumClube(String numClube) {
        this.numClube = numClube;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
}