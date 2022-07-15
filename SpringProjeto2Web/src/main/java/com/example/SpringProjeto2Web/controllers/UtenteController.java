package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.Repository;
import com.example.SpringProjeto2Web.Repository.Session;
import com.example.SpringProjeto2Web.Repository.UtenteRepository;
import com.example.SpringProjeto2Web.DAL.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/api/utente")
public class UtenteController {

    Session session = Session.getInstance();

    @Autowired
    private Repository repositorio;
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

    @PostMapping()
    public String login(Login login, Model model){

        Utente ut = repository.doLogin(login.getUserid(), login.getPassword());

        if(ut != null) {

            session.setUtenteLogado(ut.clone());

            return "redirect:/menu";

        }
        else{
            System.out.println("vazio");
        }

        return "redirect:/";
    }

    @PostMapping(value = "/update/{id}")

    public void update(@PathVariable("id") int id, @RequestBody Utente utente) throws Exception {

        Utente u = utente;

        System.out.println(u.getPrimeiroNome() + " " + id);

        repositorio.update(id, u.getUserid(), u.getPrimeiroNome(), u.getApelido(), u.getCodigopostal(), u.getNrTelemovel());

    }

}
