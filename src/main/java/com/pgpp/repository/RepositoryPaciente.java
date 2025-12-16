package com.pgpp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pgpp.model.Paciente;

// El tipo de PK cambia a String (DNI)
public interface RepositoryPaciente extends JpaRepository<Paciente, String> {
    // Ya no es necesario findByDni
}