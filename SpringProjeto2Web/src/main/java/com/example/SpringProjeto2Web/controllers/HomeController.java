package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.Session;
import jdk.jfr.Enabled;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/")
public class HomeController {

    Session session = Session.getInstance();



    @GetMapping()
    public ModelAndView getMenu(Model model) {
        ModelAndView mv = new ModelAndView("index");

        if(!session.getUtenteLogado().equals(new Utente())){

            mv.addObject("Utente",session.getUtenteLogado());
            mv.setViewName("menu");
            return mv;
        }
        return mv;
    }



}
