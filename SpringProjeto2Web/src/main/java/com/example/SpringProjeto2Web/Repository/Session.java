package com.example.SpringProjeto2Web.Repository;

import com.example.SpringProjeto2Web.DAL.Utente;

public class Session {

    private Utente utenteLogado;

    private static Session session=null;

    private Session(){

        this.utenteLogado = new Utente();

    }

    public static Session getInstance(){

        if (session == null){
            session = new Session();
        }

        return session;
    }

    public Utente getUtenteLogado() {
        return utenteLogado.clone();
    }

    public void setUtenteLogado(Utente utenteLogado) {
        this.utenteLogado = utenteLogado.clone();
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        Session.session = session;
    }
}
