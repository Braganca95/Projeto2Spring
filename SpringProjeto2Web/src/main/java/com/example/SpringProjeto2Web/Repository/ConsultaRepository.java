package com.example.SpringProjeto2Web.Repository;

import com.example.SpringProjeto2Web.DAL.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Integer> {

    Optional<List<Consulta>> findConsultasByIdUtente(int id);
}
