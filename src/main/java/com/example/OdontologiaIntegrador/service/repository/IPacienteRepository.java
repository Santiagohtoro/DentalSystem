package com.example.OdontologiaIntegrador.service.repository;

import com.example.OdontologiaIntegrador.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
