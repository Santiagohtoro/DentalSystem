package com.example.OdontologiaIntegrador.service.repository;

import com.example.OdontologiaIntegrador.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno,Long> {
}
