package com.pgpp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
// Hereda DNI como PK, nombre, apellidos, email.
public class Paciente extends Usuario {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento; // <- Atributo específico recuperado

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "paciente_medicamentos",
        // Usamos el DNI del Paciente (String) para la unión:
        joinColumns = @JoinColumn(name = "paciente_dni"), 
        inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<Medicamento> tratamientos = new ArrayList<>();

    public Paciente() {}

    public void agregarMedicamento(Medicamento med) {
        this.tratamientos.add(med);
    }

    // Getters y Setters específicos
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    
    public List<Medicamento> getTratamientos() { return tratamientos; }
    public void setTratamientos(List<Medicamento> tratamientos) { this.tratamientos = tratamientos; }
}