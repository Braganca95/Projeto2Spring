package com.example.SpringProjeto2Web.DAL;

public class Cookies {

    private Utente utente;

    public Cookies(){
        this.utente = null;
    }

    public Cookies(Utente utente) {
        this.utente = utente;
    }



    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }




}

