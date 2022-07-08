package com.example.OdontologiaIntegrador.dto;

import com.example.OdontologiaIntegrador.model.Odontologo;
import com.example.OdontologiaIntegrador.model.Paciente;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class TurnoDTO {

    private Long id;
    private Date date;
    private Odontologo odontologo;
    private Paciente paciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
