package com.example.OdontologiaIntegrador.service.impl;

import com.example.OdontologiaIntegrador.model.Paciente;
import com.example.OdontologiaIntegrador.dto.PacienteDTO;
import com.example.OdontologiaIntegrador.repository.IPacienteRepository;
import com.example.OdontologiaIntegrador.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearPaciente(PacienteDTO paciente) {
        Paciente newPaciente = mapper.convertValue(paciente,Paciente.class);
        pacienteRepository.save(newPaciente);
    }

    @Override
    public PacienteDTO leerPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO newPaciente = null;

        if(paciente.isPresent())
            newPaciente = mapper.convertValue(paciente, PacienteDTO.class);

        return newPaciente;
    }

    @Override
    public void modificarPaciente(PacienteDTO paciente) {
        Paciente newPaciente = mapper.convertValue(paciente,Paciente.class);
        pacienteRepository.save(newPaciente);
    }

    @Override
    public void borrarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> obtenerPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<PacienteDTO>();
        for (Paciente p: pacientes) {
            pacientesDTO.add((mapper.convertValue(p,PacienteDTO.class)));
        }
        return pacientesDTO;
    }
}
