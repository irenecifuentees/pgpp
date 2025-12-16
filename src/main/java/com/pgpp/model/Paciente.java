package com.pgpp.model;

import java.time.LocalDate;
import java.util.ArrayList; // Importante para fechas
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Paciente {

    @Id
    @Column(length = 9) // Opcional: limita el tamaño en base de datos
    private String dni; // Ahora el DNI es la CLAVE PRIMARIA

    private String nombre;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // Define el formato (Año-Mes-Dia)
    private LocalDate fechaNacimiento;

    // RELACIÓN MUCHOS A MUCHOS
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "paciente_medicamentos",
        joinColumns = @JoinColumn(name = "paciente_dni"), // Ahora la columna se llamará dni
        inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<Medicamento> tratamientos = new ArrayList<>();

    // Constructor vacío
    public Paciente() {}

    // Constructor con datos
    public Paciente(String dni, String nombre, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Método helper
    public void agregarMedicamento(Medicamento med) {
        this.tratamientos.add(med);
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public List<Medicamento> getTratamientos() { return tratamientos; }
    public void setTratamientos(List<Medicamento> tratamientos) { this.tratamientos = tratamientos; }
}