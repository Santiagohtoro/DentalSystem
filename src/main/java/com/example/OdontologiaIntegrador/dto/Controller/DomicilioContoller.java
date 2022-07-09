package com.example.OdontologiaIntegrador.dto.Controller;

import com.example.OdontologiaIntegrador.dto.DomicilioDTO;
import com.example.OdontologiaIntegrador.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/domicilios")
public class DomicilioContoller {
    @Autowired
    IDomicilioService domicilioService;


    @PostMapping("/crear")
    public ResponseEntity<?> guardarDomicilio(@RequestBody DomicilioDTO Domicilio){
        System.out.println(Domicilio.getCalle());
        domicilioService.crearDomicilio(Domicilio);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarDomicilio(@RequestBody DomicilioDTO Domicilio){
        domicilioService.modificarDomicilio(Domicilio);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDomicilio(@PathVariable Long id){
        return ResponseEntity.ok(domicilioService.leerDomicilio(id));
    }

    @GetMapping
    public Set<?> listarTodas(){
        return domicilioService.obtenerDomicilios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id) {
        domicilioService.borrarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
