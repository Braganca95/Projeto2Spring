package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Account;
import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.Repository;
import com.example.SpringProjeto2Web.Repository.Session;
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

    Session session = Session.getInstance();
    @Autowired
   private Repository repositorio;
    @Autowired
    private UtenteRepository repository;

    @GetMapping()
    public ModelAndView account(){
        ModelAndView mv = new ModelAndView();


        if(session.getUtenteLogado().equals(new Utente())){
            System.out.println("*****");
            System.out.println("nulo");
            System.out.println("*******");
            mv.setViewName("index");
            return mv;
        }

        mv.setViewName("editAccount");

        mv.addObject("Utente",session.getUtenteLogado());
        return mv;

    }

    @PostMapping()
    public String update(Utente u) throws Exception {


        System.out.println("#########");
        System.out.println(u.getUserid() + u.getPrimeiroNome() + u.getApelido() + u.getCodigopostal()  + u.getNrTelemovel());
        System.out.println("#########");



        repositorio.update(2, u.getUserid(), u.getPrimeiroNome(), u.getApelido(), u.getCodigopostal(), u.getNrTelemovel());



        return "redirect:/account";

    }

}
