package br.com.integrador.futdosguri.model;

public class Ginasio {

    private long idGinasio;
    private String cnpjGinasio;
    private String horariosLivres;
    private String numGinasio;

    public Ginasio(){ }

    public Ginasio(long idGinasio, String cnpjGinasio, String horariosLivres, String numGinasio) {
        super();
        this.idGinasio = idGinasio;
        this.cnpjGinasio = cnpjGinasio;
        this.horariosLivres = horariosLivres;
        this.numGinasio = numGinasio;
    }

    public long getIdGinasio() {
        return idGinasio;
    }

    public void setIdGinasio(long idGinasio) {
        this.idGinasio = idGinasio;
    }

    public String getCnpjGinasio() {
        return cnpjGinasio;
    }

    public void setCnpjGinasio(String cnpjGinasio) {
        this.cnpjGinasio = cnpjGinasio;
    }

    public String getHorariosLivres() {
        return horariosLivres;
    }

    public void setHorariosLivres(String horariosLivres) {
        this.horariosLivres = horariosLivres;
    }

    public String getNumGinasio() {
        return numGinasio;
    }

    public void setNumGinasio(String numGinasio) {
        this.numGinasio = numGinasio;
    }
}