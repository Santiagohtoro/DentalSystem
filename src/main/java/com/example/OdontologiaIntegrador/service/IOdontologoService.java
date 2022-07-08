package com.example.OdontologiaIntegrador.service;

import com.example.OdontologiaIntegrador.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO odontologo);
    OdontologoDTO leerOdontologo(Long id);
    void modificarOdontologo (OdontologoDTO odontologo);
    void borrarOdontologo(Long id);
    Set<OdontologoDTO> obtenerOdontologos();
}
