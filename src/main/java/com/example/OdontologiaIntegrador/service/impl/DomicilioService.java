package com.example.OdontologiaIntegrador.service.impl;

import com.example.OdontologiaIntegrador.dto.DomicilioDTO;
import com.example.OdontologiaIntegrador.model.Domicilio;
import com.example.OdontologiaIntegrador.repository.IDomicilioRepository;
import com.example.OdontologiaIntegrador.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearDomicilio(DomicilioDTO domicilio) {
        Domicilio newDomicilio = mapper.convertValue(domicilio,Domicilio.class);
        domicilioRepository.save(newDomicilio);
    }

    @Override
    public DomicilioDTO leerDomicilio(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO newdomicilio = null;

        if(domicilio.isPresent())
            newdomicilio = mapper.convertValue(domicilio, DomicilioDTO.class);

        return newdomicilio;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilio) {
        Domicilio newdomicilio = mapper.convertValue(domicilio,Domicilio.class);
        domicilioRepository.save(newdomicilio);
    }

    @Override
    public void borrarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public Set<DomicilioDTO> obtenerDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domiciliosDTO = new HashSet<DomicilioDTO>();
        for (Domicilio d: domicilios) {
            domiciliosDTO.add((mapper.convertValue(d,DomicilioDTO.class)));
        }
        return domiciliosDTO;
    }
}
