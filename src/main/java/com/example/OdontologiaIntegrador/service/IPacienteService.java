package com.example.OdontologiaIntegrador.service;

import com.example.OdontologiaIntegrador.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    void crearPaciente(PacienteDTO paciente);
    PacienteDTO leerPaciente(Long id);
    void modificarPaciente (PacienteDTO paciente);
    void borrarPaciente(Long id);
    Set<PacienteDTO> obtenerPacientes();
}
