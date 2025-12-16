package com.pgpp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pgpp.model.Medico;

// El tipo de PK cambia a String (DNI)
public interface RepositoryMedico extends JpaRepository<Medico, String> {
    
    // Necesario para el login por nombre, aunque DNI es la PK
    Medico findByNombre(String nombre); 
}