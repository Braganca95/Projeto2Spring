package com.example.SpringProjeto2Web.DAL;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consulta")
public class Consulta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "data_realizada")
    private Date dataRealizada;
    @Basic
    @Column(name = "id_utente")
    private int idUtente;
    @Basic
    @Column(name = "relatorio")
    private String relatorio;
    @Basic
    @Column(name = "estado")
    private String estado;
    @Basic
    @Column(name = "id_fisioterapeuta")
    private int idFisioterapeuta;
    @Basic
    @Column(name = "id_medico")
    private int idMedico;
    @Basic
    @Column(name = "pagamento")
    private int pagamento;
    @Basic
    @Column(name = "tipo_consulta")
    private int tipoConsulta;
    @Basic
    @Column(name = "tratamento")
    private int tratamento;

    public Consulta(){

        this.dataRealizada = new Date();
        this.estado = "";
        this.id = 0;
        this.idFisioterapeuta = 0;
        this.idMedico = 0;
        this.idUtente = 0;
        this.pagamento = 0;
        this.relatorio = "";
        this.tipoConsulta = 0;
        this.tratamento = 0;
    }

    public Consulta(Integer id, Date dataRealizada, int idUtente, String relatorio, String estado, int idFisioterapeuta, int idMedico, int pagamento, int tipoConsulta, int tratamento) {
        this.id = id;
        this.dataRealizada = dataRealizada;
        this.idUtente = idUtente;
        this.relatorio = relatorio;
        this.estado = estado;
        this.idFisioterapeuta = idFisioterapeuta;
        this.idMedico = idMedico;
        this.pagamento = pagamento;
        this.tipoConsulta = tipoConsulta;
        this.tratamento = tratamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataRealizada() {
        return dataRealizada;
    }

    public void setDataRealizada(Date dataRealizada) {
        this.dataRealizada = dataRealizada;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdFisioterapeuta() {
        return idFisioterapeuta;
    }

    public void setIdFisioterapeuta(int idFisioterapeuta) {
        this.idFisioterapeuta = idFisioterapeuta;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public int getTratamento() {
        return tratamento;
    }

    public void setTratamento(int tratamento) {
        this.tratamento = tratamento;
    }

}