package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.UtenteRepository;
import com.example.SpringProjeto2Web.DAL.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/utente")
public class UtenteController {
    @Autowired
    private UtenteRepository repository;

    @GetMapping(value = "/utentes")
    public List<Utente> list () {
        System.out.println("Recebendo Utentes");
        return repository.getUtentes();
    }
    @GetMapping(value = "/utentes/id/{id}")
    public Utente listbyid (@PathVariable("id") int id) {
        System.out.println("Recebendo Utentes");
        return repository.getUtenteById(id).orElse(null);
    }
    @PostMapping("/create")
    public void create (@RequestBody Utente utente){
        System.out.println("Criando Utente " + utente.getPrimeiroNome());
        repository.save(utente);
    }

  /*  public Utente getUtente(){

        Utente ut = new Utente();

        System.out.println(repository.getUtentes());
        ut = repository.getUtenteByUseridAndPassword(this.userid,this.password).orElse(null);

        if(ut == null) {
            System.out.println();
            System.out.println("Nulo");
            System.out.println();
            return null;
        }

        return ut.clone();


    }*/

    @PostMapping("/")
    public String doLogin(Login login){

        System.out.println();
        System.out.println(login.getUserid());
        System.out.println();
        System.out.println(repository.findAll());
        System.out.println();

        Optional<Utente> ut = repository.getUtenteByUseridAndPassword(login.getUserid(),login.getPassword());


        System.out.println();
        if(ut.isPresent()) {
            System.out.println(ut.get().getPrimeiroNome() + ut.get().getPassword());
        }
        else{
            System.out.println("vazio");
        }
        System.out.println();

        return "redirect:/menu";

    }
}
