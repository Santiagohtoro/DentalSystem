package com.example.OdontologiaIntegrador.Controller;

import com.example.OdontologiaIntegrador.dto.PacienteDTO;
import com.example.OdontologiaIntegrador.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> guardarPaciente(@RequestBody PacienteDTO paciente){
        pacienteService.crearPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO paciente){
        pacienteService.modificarPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPaciente(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.leerPaciente(id));
    }

    @GetMapping
    public Set<?> listarTodas(){
        return pacienteService.obtenerPacientes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        pacienteService.borrarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
