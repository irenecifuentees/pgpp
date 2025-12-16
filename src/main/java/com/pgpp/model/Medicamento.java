package com.pgpp.model;

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
    private String vulnAnciano;;

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long id) {
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

    public String getVulnAnciano() {
        return vulnAnciano;
    }

    public void setVulnAnciano(String vulnAnciano) {
        this.vulnAnciano = vulnAnciano;
    }
}
