package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.Session;
import com.example.SpringProjeto2Web.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    Session session = Session.getInstance();

    @Autowired
    private UtenteRepository repository;


    @GetMapping()
    public ModelAndView getMenu(Model model) {
        ModelAndView mv = new ModelAndView("menu");

        if(session.getUtenteLogado().equals(new Utente())){
            System.out.println("*****");
            System.out.println("nulo");
            System.out.println("*******");
            mv.setViewName("index");
            return mv;
        }



        mv.addObject("Utente",session.getUtenteLogado());
        return mv;
    }

}
