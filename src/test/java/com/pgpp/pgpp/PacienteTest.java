package com.pgpp.pgpp;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pgpp.model.Medicamento;
import com.pgpp.model.Paciente;

public class PacienteTest {

    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        paciente = new Paciente();
    }

    @Test
    @DisplayName("Comprueba que la fecha de nacimiento se obtiene correctamente")
    public void fechaNacimiento_getFecha_Correcto() {
        // Arrange
        LocalDate fecha = LocalDate.of(1990, 1, 1);
        paciente.setFechaNacimiento(fecha);

        // Act
        LocalDate fechaObtained = paciente.getFechaNacimiento();

        // Assert
        assertEquals(fecha, fechaObtained);
    }

    @Test
    @DisplayName("Comprueba que se puede agregar un medicamento a la lista")
    public void agregarMedicamento_medicamentoNuevo_listaActualizada() {
        // Arrange
        Medicamento med = new Medicamento();
        med.setNombre("Ibuprofeno");

        // Act
        paciente.agregarMedicamento(med);
        int size = paciente.getTratamientos().size();

        // Assert
        assertEquals(1, size);
        assertTrue(paciente.getTratamientos().contains(med));
    }
}