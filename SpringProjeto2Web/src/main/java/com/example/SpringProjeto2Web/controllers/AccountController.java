package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Account;
import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/account")
public class AccountController {

    @Autowired
    private UtenteRepository repository;

    @GetMapping()
    public ModelAndView account(){
        ModelAndView mv = new ModelAndView("editAccount");

        if( repository.getUtenteById(1).isPresent()) {
            Utente ut = repository.getUtenteById(1).get();
            System.out.println("***********");
            System.out.println(ut.getPrimeiroNome());
            System.out.println("***********");
            mv.addObject("Utente",ut);
        }


        return mv;

    }

    @PostMapping()
    public String update(Account ac){
        ModelAndView mv = new ModelAndView("editAccount");


        System.out.println();
        System.out.println(ac.getPassword());
        System.out.println();

/*
        if( repository.getUtenteById(1).isPresent()) {
            Utente ut = repository.getUtenteById(1).get();

            ut.setApelido(ac.getApelido());
            ut.setPassword(ac.getPassword());
            ut.setPrimeiroNome(ac.getPrimeiroNome());
            ut.se
            System.out.println("***********");
            System.out.println(ut.getPrimeiroNome());
            System.out.println("***********");



            this.repository.updateUtenteById(ut.getUserid(),ac.getPassword(),ac.getPrimeiroNome(),ac.getApelido(),ac.getNrTelemovel(),ut.getNif(),ut.getCodigopostal(),ut.getId());
        }*/



        return "redirect:/account";

    }

}
