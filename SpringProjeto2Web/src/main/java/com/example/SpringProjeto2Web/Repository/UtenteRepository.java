package com.example.SpringProjeto2Web.Repository;

import com.example.SpringProjeto2Web.DAL.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

        List<Utente> getUtentes();

        Optional<Utente> getUtenteById(int id);

        Optional<Utente> getUtenteByUseridAndPassword(String userid, String password);

        Utente doLogin(String username, String password);

        //Void updateUtenteById(String userid, String password, String primeiroNome, String apelido, String nrTelemovel, String nif, String codigoPostal, int id);

        Utente findUtenteByUseridAndPassword(String userid, String password);



}
