package com.pgpp.model;

import jakarta.persistence.Entity;

@Entity
// Hereda DNI como PK, nombre, apellidos, email.
public class Medico extends Usuario {

    private String especialidad;
    private String password; // Contraseña simple (texto plano para este ejemplo)

    public Medico() {}

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}