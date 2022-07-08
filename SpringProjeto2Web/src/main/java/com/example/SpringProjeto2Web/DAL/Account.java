package com.example.SpringProjeto2Web.DAL;

public class Account{

    private String password;
    private String primeiroNome;
    private String apelido;
    private String nrTelemovel;


    public Account(){
        this.apelido = "";
        this.nrTelemovel = "";
        this.password = "";
        this.primeiroNome = "";
    }

    public Account(String password, String primeiroNome, String apelido, String nrTelemovel) {
        this.password = password;
        this.primeiroNome = primeiroNome;
        this.apelido = apelido;
        this.nrTelemovel = nrTelemovel;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNrTelemovel() {
        return nrTelemovel;
    }

    public void setNrTelemovel(String nrTelemovel) {
        this.nrTelemovel = nrTelemovel;
    }


}
