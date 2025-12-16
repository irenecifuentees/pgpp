package com.pgpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgpp.model.Medicamento;

public interface RepositoryMedicamento extends JpaRepository <Medicamento, Long> {
    
}
