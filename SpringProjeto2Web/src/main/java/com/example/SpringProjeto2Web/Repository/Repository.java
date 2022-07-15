package com.example.SpringProjeto2Web.Repository;

import com.example.SpringProjeto2Web.DAL.Utente;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager em;

    public List<Utente> findAll() {
        TypedQuery<Utente> query = em.createQuery("SELECT t FROM Utente t", Utente.class);
        return query.getResultList();
    }
    @Transactional
    public void update(Integer id, String userid, String primeiroNome, String apelido, String codigoPostal, String nrTelemovel) throws Exception {
        try {
            Query updateUtenteById = em.createNamedQuery("updateUtenteById");
            updateUtenteById.setParameter("id", id).setParameter("userid", userid).setParameter("primeiroNome", primeiroNome).setParameter("apelido", apelido).setParameter("codigoPostal", codigoPostal).setParameter("nrTelemovel", nrTelemovel).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


}
