package com.pgpp.pgpp;
import jakarta.persistence.*;

@Entity
public class Medicamento {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String principioActivo;
    private String codigoATC;
    private String dosis;

    public Medicamento() {}

    public Medicamento(String nombre, String principioActivo, String codigoATC, String dosis) {
        this.nombre = nombre;
        this.principioActivo = principioActivo;
        this.codigoATC = codigoATC;
        this.dosis = dosis;
    }

    // getters y setters
}
