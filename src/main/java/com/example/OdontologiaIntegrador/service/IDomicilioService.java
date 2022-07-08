package com.example.OdontologiaIntegrador.service;

import com.example.OdontologiaIntegrador.dto.DomicilioDTO;

import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio(DomicilioDTO domicilio);
    DomicilioDTO leerDomicilio(Long id);
    void modificarDomicilio (DomicilioDTO domicilio);
    void borrarDomicilio(Long id);
    Set<DomicilioDTO> obtenerDomicilios();
}
