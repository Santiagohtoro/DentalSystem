package com.example.OdontologiaIntegrador.service;

import com.example.OdontologiaIntegrador.dto.PacienteDTO;
import com.example.OdontologiaIntegrador.dto.TurnoDTO;
import com.example.OdontologiaIntegrador.model.Turno;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turno);
    Set<TurnoDTO> obtenerTurnos();
    TurnoDTO leerTurno(Long id);
    void modificarTurno (TurnoDTO turno);
    void borrarTurno(Long id);
}
