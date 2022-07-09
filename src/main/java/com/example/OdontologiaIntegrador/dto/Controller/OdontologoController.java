package com.example.OdontologiaIntegrador.dto.Controller;

import com.example.OdontologiaIntegrador.dto.OdontologoDTO;
import com.example.OdontologiaIntegrador.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> guardarOdontologo(@RequestBody OdontologoDTO odontologo){
        odontologoService.crearOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO odontologo){
        odontologoService.modificarOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarOdontologo(@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.leerOdontologo(id));
    }

    @GetMapping
    public Set<?> listarTodas(){
        return odontologoService.obtenerOdontologos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) {
        odontologoService.borrarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
