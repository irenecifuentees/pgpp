package com.pgpp.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

// @MappedSuperclass indica a JPA que sus campos deben ser copiados 
// a las tablas de las entidades que la heredan (Medico y Paciente), 
// pero NO debe crear una tabla propia 'usuario'.
@MappedSuperclass 
public abstract class Usuario {

    // El DNI es la Clave Primaria (PK) para Medico y Paciente.
    // IMPORTANTE: Ya no es autogenerado.
    @Id
    private String dni; 

    private String nombre;
    private String apellidos;
    private String email;

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}