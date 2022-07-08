package com.example.OdontologiaIntegrador.service.impl;

import com.example.OdontologiaIntegrador.dto.TurnoDTO;
import com.example.OdontologiaIntegrador.model.Turno;
import com.example.OdontologiaIntegrador.repository.ITurnoRepository;
import com.example.OdontologiaIntegrador.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public void crearTurno(TurnoDTO turno) {
        Turno newTurno = mapper.convertValue(turno, Turno.class);
        turnoRepository.save(newTurno);
    }

    @Override
    public TurnoDTO leerTurno(Long id) {
        Optional<Turno> Turno = turnoRepository.findById(id);
        TurnoDTO newTurno = null;

        if(Turno.isPresent())
            newTurno = mapper.convertValue(Turno, TurnoDTO.class);

        return newTurno;
    }

    @Override
    public void modificarTurno(TurnoDTO Turno) {
        Turno newTurno = mapper.convertValue(Turno,Turno.class);
        turnoRepository.save(newTurno);
    }

    @Override
    public void borrarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> obtenerTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<TurnoDTO>();
        for (Turno t: turnos) {
            turnoDTOS.add(mapper.convertValue(t,TurnoDTO.class));
        }
        return turnoDTOS;
    }
}
