package com.pgpp.pgpp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;


@Entity
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@ManyToOne
    //private PosibleTratamiento posibleTratamiento;

    private Long idMedicamento;   
    private String nombre;
    private String prActivo;

    public Long getId() {
        return idMedicamento;
    }

    public void setId(Long id) {
        this.idMedicamento = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrActivo() {
        return prActivo;
    }

    public void setPrActivo(String prActivo) {
        this.prActivo = prActivo;
    }
}