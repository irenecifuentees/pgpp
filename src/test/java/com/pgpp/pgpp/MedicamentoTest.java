package com.pgpp.pgpp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pgpp.model.Medicamento;

public class MedicamentoTest {

    private Medicamento medicamento;

    @BeforeEach
    public void setUp() {
        medicamento = new Medicamento();
    }

    @Test
    @DisplayName("Comprueba que el id se obtiene correctamente")
    public void id_getId_Correcto() {
        // Arrange
        Long id = 1L;
        medicamento.setIdMedicamento(id);

        // Act
        Long idObtained = medicamento.getIdMedicamento();

        // Assert
        assertEquals(id, idObtained);
    }

    @Test
    @DisplayName("Comprueba que el nombre se obtiene correctamente")
    public void nombre_getNombre_Correcto() {
        // Arrange
        String nombre = "Paracetamol";
        medicamento.setNombre(nombre);

        // Act
        String nombreObtained = medicamento.getNombre();

        // Assert
        assertEquals(nombre, nombreObtained);
    }

    @Test
    @DisplayName("Comprueba que el principio activo se obtiene correctamente")
    public void prActivo_getPrActivo_Correcto() {
        // Arrange
        String prActivo = "Paracetamol 500mg";
        medicamento.setPrActivo(prActivo);

        // Act
        String prActivoObtained = medicamento.getPrActivo();

        // Assert
        assertEquals(prActivo, prActivoObtained);
    }

    @Test
    @DisplayName("Comprueba que la vulnerabilidad anciano se obtiene correctamente")
    public void vulnAnciano_getVulnAnciano_Correcto() {
        // Arrange
        String vuln = "Baja";
        medicamento.setVulnAnciano(vuln);

        // Act
        String vulnObtained = medicamento.getVulnAnciano();

        // Assert
        assertEquals(vuln, vulnObtained);
    }
}

