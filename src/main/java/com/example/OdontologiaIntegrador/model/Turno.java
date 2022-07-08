package com.example.OdontologiaIntegrador.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Turno")
public class Turno {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="odontologo_id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

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
}
