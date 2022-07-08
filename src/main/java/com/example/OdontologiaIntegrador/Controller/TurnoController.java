package com.example.OdontologiaIntegrador.Controller;

import com.example.OdontologiaIntegrador.dto.TurnoDTO;
import com.example.OdontologiaIntegrador.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> guardarTurno(@RequestBody TurnoDTO turno){
        turnoService.crearTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDTO turno){
        turnoService.modificarTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarturno(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.leerTurno(id));
    }

    @GetMapping
    public Set<?> listarTodas(){
        return turnoService.obtenerTurnos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarturno(@PathVariable Long id) {
        turnoService.borrarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
