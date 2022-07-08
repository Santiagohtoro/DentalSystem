package com.example.OdontologiaIntegrador.repository;

import com.example.OdontologiaIntegrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {
}
