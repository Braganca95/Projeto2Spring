package com.example.SpringProjeto2Web.controllers;

import com.example.SpringProjeto2Web.DAL.Consulta;
import com.example.SpringProjeto2Web.DAL.Utente;
import com.example.SpringProjeto2Web.Repository.ConsultaRepository;
import com.example.SpringProjeto2Web.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/appointments")
public class AppointmentsController {

    @Autowired
    private UtenteRepository repository;
   @Autowired
    private ConsultaRepository consultaRepository;


    @GetMapping()
    public ModelAndView getAppointments() {
        ModelAndView mv = new ModelAndView("appointments");

        /*if( repository.getUtenteById(1).isPresent()) {
            //Utente ut = repository;
            System.out.println();
            System.out.println(ut.getPrimeiroNome());
            System.out.println();
            mv.addObject("Utente",ut);
        }*/

        if(this.repository.getUtenteById(1).isPresent()){
            List<Consulta> consultas = this.consultaRepository.findConsultasByIdUtente(1).get();

            mv.addObject("consultas",consultas);

            for(Consulta x : consultas){
                System.out.println("******");
                System.out.println(x.getIdMedico());
                System.out.println("******");
            }

        }


        return mv;
    }
}
