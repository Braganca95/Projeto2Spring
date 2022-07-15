package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/consulta")
public class ConsultaController {

    Session session = Session.getInstance();

    @GetMapping
    public ModelAndView create(){
        ModelAndView mv = new ModelAndView("makeAppointment");

        if(session.getUtenteLogado().equals(new Utente())){

            mv.setViewName("index");
            return mv;
        }


        return mv;

    }
}
