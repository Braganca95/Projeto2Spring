package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private UtenteRepository repository;


    @GetMapping()
    public ModelAndView getMenu() {
        ModelAndView mv = new ModelAndView("menu");

        if( repository.getUtenteById(1).isPresent()) {
            Utente ut = repository.getUtenteById(1).get();
            System.out.println();
            System.out.println(ut.getPrimeiroNome());
            System.out.println();
            mv.addObject("Utente",ut);
        }


        return mv;
    }

}
