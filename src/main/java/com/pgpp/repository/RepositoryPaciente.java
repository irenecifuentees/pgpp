package com.pgpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgpp.model.Paciente;

// El segundo parámetro es String porque el ID es el DNI
public interface RepositoryPaciente extends JpaRepository<Paciente, String> {
}