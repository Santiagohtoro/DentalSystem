package com.example.OdontologiaIntegrador.service;

import com.example.OdontologiaIntegrador.dto.PacienteDTO;
import com.example.OdontologiaIntegrador.model.Domicilio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;

    @Test
    void crearPaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Santiago");
        pacienteDTO.setApellido("Hernandez Toro");
        pacienteDTO.setDni("1234");
        pacienteDTO.setEmail("santiagohtoro@outlook.com");
        pacienteDTO.setFechaIngreso(new Date());
        pacienteService.crearPaciente(pacienteDTO);

        assertTrue(pacienteService.obtenerPacientes().size()>0);
    }
}