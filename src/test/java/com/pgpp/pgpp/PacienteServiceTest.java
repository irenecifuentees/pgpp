package com.pgpp.pgpp;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pgpp.model.Medicamento;
import com.pgpp.model.Paciente;
import com.pgpp.repository.RepositoryMedicamento;
import com.pgpp.repository.RepositoryPaciente;
import com.pgpp.service.MedicoService;
import com.pgpp.service.PacienteService;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @Mock
    RepositoryPaciente repoPaciente;

    @Mock
    RepositoryMedicamento repoMedicamento;

    @Mock
    MedicoService medicoService;

    @InjectMocks
    private PacienteService pacienteService;

    @Test
    @DisplayName("Comprueba que no prescribe medicamento si validacion medico falla")
    public void prescribir_medicoInvalido_devuelveFalse() {
        // Arrange
        String dniM = "Med1";
        String pass = "wrong";
        when(medicoService.validarMedico(dniM, pass)).thenReturn(false);

        // Act
        boolean result = pacienteService.prescribirMedicamentoSeguro("Pac1", 1L, dniM, pass);

        // Assert
        assertFalse(result);
        verify(repoPaciente, never()).save(any(Paciente.class));
    }

    @Test
    @DisplayName("Comprueba que prescribe medicamento si todo es correcto")
    public void prescribir_todoCorrecto_devuelveTrueYGuarda() {
        // Arrange
        String dniP = "Pac1";
        Long idMed = 1L;
        String dniM = "Med1";
        String pass = "pass";

        Paciente paciente = new Paciente();
        Medicamento medicamento = new Medicamento();

        when(medicoService.validarMedico(dniM, pass)).thenReturn(true);
        when(repoPaciente.findById(dniP)).thenReturn(Optional.of(paciente));
        when(repoMedicamento.findById(idMed)).thenReturn(Optional.of(medicamento));

        // Act
        boolean result = pacienteService.prescribirMedicamentoSeguro(dniP, idMed, dniM, pass);

        // Assert
        assertTrue(result);
        verify(repoPaciente).save(paciente);
    }
}