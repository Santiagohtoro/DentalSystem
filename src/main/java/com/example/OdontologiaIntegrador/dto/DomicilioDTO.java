package com.example.OdontologiaIntegrador.dto;

import com.example.OdontologiaIntegrador.model.Domicilio;

import java.util.Set;


public class DomicilioDTO {
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    private Set<Domicilio> domicilio;

    public Set<Domicilio> getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Set<Domicilio> domicilio) {
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
