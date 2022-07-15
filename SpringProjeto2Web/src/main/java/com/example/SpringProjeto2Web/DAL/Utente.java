package com.example.SpringProjeto2Web.DAL;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Utente.doLogin", query = "SELECT p FROM Utente p WHERE p.userid = :username AND p.password = function('crypt',:password,p.password)")
@NamedQuery(name = "getUtenteNomeByID", query = "SELECT p.primeiroNome FROM Utente p WHERE p.id = :id")
@NamedQuery(name="getUtentes", query="SELECT e FROM Utente e")
@NamedQuery(name="getUtenteById", query="SELECT e FROM Utente e WHERE e.id=:id")
//@NamedQuery(name="Utente.updateUtenteById", query="UPDATE Utente u SET u.userid=:userid, u.primeiroNome=:primeiroNome, u.apelido=:apelido, u.password=function('crypt',:password,u.password), u.codigopostal=:codigoPostal, u.nrTelemovel=:nrTelemovel, u.nif=:nif WHERE u.id=:id")
@NamedQuery(name="Utente.getUtentes", query="SELECT e FROM Utente e")
@NamedQuery(name="Utente.getUtenteById", query="SELECT e FROM Utente e WHERE e.id=:id")
@NamedQuery(name="updateUtenteById", query="UPDATE Utente u SET u.userid=:userid, u.primeiroNome=:primeiroNome, u.apelido=:apelido, u.codigopostal=:codigoPostal, u.nrTelemovel=:nrTelemovel WHERE u.id=:id")
public class Utente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "primeiro_nome")
    private String primeiroNome;
    @Basic
    @Column(name = "apelido")
    private String apelido;
    @Basic
    @Column(name = "nr_telemovel")
    private String nrTelemovel;
    @Basic
    @Column(name = "codigopostal")
    private String codigopostal;
    @Basic
    @Column(name = "userid")
    private String userid;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "nif")
    private String nif;

    public Utente(int id, String primeiroNome, String apelido, String nrTelemovel, String codigopostal, String userid, String password, String nif) {
        this.primeiroNome = primeiroNome;
        this.apelido = apelido;
        this.nrTelemovel = nrTelemovel;
        this.codigopostal = codigopostal;
        this.userid = userid;
        this.password = password;
        this.nif = nif;
        this.id = id;
    }

    public Utente() {

        this.id = 0;
        this.apelido = "";
        this.primeiroNome = "";
        this.nrTelemovel = "";
        this.userid = "";
        this.password = "";
        this.nif = "";
        this.codigopostal = "";

    }

    public Utente clone(){

        return new Utente(this.getId(), this.getPrimeiroNome(), this.getApelido(), this.getNrTelemovel(), this.getCodigopostal(), this.getUserid(), this.getPassword(), this.getNif());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utente utente = (Utente) o;

        if (id != utente.id) return false;
        if (primeiroNome != null ? !primeiroNome.equals(utente.primeiroNome) : utente.primeiroNome != null)
            return false;
        if (apelido != null ? !apelido.equals(utente.apelido) : utente.apelido != null) return false;
        if (nrTelemovel != null ? !nrTelemovel.equals(utente.nrTelemovel) : utente.nrTelemovel != null) return false;
        if (codigopostal != null ? !codigopostal.equals(utente.codigopostal) : utente.codigopostal != null)
            return false;
        if (userid != null ? !userid.equals(utente.userid) : utente.userid != null) return false;
        if (password != null ? !password.equals(utente.password) : utente.password != null) return false;
        if (nif != null ? !nif.equals(utente.nif) : utente.nif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (primeiroNome != null ? primeiroNome.hashCode() : 0);
        result = 31 * result + (apelido != null ? apelido.hashCode() : 0);
        result = 31 * result + (nrTelemovel != null ? nrTelemovel.hashCode() : 0);
        result = 31 * result + (codigopostal != null ? codigopostal.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        return result;
    }

}
