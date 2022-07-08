package com.example.OdontologiaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Paciente")
public class Paciente {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_domicilio", referencedColumnName ="id" )
    private Domicilio domicilio;

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos;



    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
