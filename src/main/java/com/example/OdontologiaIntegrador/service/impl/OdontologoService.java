package com.example.OdontologiaIntegrador.service.impl;

import com.example.OdontologiaIntegrador.dto.OdontologoDTO;
import com.example.OdontologiaIntegrador.model.Odontologo;
import com.example.OdontologiaIntegrador.repository.IOdontologoRepository;
import com.example.OdontologiaIntegrador.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    private IOdontologoRepository OdontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearOdontologo(OdontologoDTO Odontologo) {
        Odontologo newOdontologo = mapper.convertValue(Odontologo,Odontologo.class);
        OdontologoRepository.save(newOdontologo);
    }

    @Override
    public OdontologoDTO leerOdontologo(Long id) {
        Optional<Odontologo> Odontologo = OdontologoRepository.findById(id);
        OdontologoDTO newOdontologo = null;

        if(Odontologo.isPresent())
            newOdontologo = mapper.convertValue(Odontologo, OdontologoDTO.class);

        return newOdontologo;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO Odontologo) {
        Odontologo newOdontologo = mapper.convertValue(Odontologo,Odontologo.class);
        OdontologoRepository.save(newOdontologo);
    }

    @Override
    public void borrarOdontologo(Long id) {
        OdontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> obtenerOdontologos() {
        List<Odontologo> Odontologos = OdontologoRepository.findAll();
        Set<OdontologoDTO> OdontologosDTO = new HashSet<OdontologoDTO>();
        for (Odontologo p: Odontologos) {
            OdontologosDTO.add((mapper.convertValue(p,OdontologoDTO.class)));
        }
        return OdontologosDTO;
    }
}
