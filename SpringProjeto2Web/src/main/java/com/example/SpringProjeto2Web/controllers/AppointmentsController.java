package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Consulta;
import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.ConsultaRepository;
import com.example.SpringProjeto2Web.Repository.Session;
import com.example.SpringProjeto2Web.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/appointments")
public class AppointmentsController {

    Session session = Session.getInstance();

    @Autowired
    private UtenteRepository repository;
   @Autowired
    private ConsultaRepository consultaRepository;


    @GetMapping()
    public ModelAndView getAppointments(Model model) {
        ModelAndView mv = new ModelAndView("appointments");

        Utente ut = session.getUtenteLogado().clone();

        if(session.getUtenteLogado().equals(new Utente())){
            System.out.println("*****");
            System.out.println("nulo");
            System.out.println("*******");
            mv.setViewName("index");
            return mv;
        }

        mv.setViewName("appointments");

            if(this.consultaRepository.findConsultasByIdUtente(ut.getId()).isPresent()){
                List<Consulta> consultas = this.consultaRepository.findConsultasByIdUtente(ut.getId()).get();

                mv.addObject("consultas",consultas);

        }

        return mv;
    }
}
