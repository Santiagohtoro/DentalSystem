package com.example.OdontologiaIntegrador.service.repository;

import com.example.OdontologiaIntegrador.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {
}
