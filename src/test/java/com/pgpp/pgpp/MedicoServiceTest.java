package com.pgpp.pgpp;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pgpp.model.Medico;
import com.pgpp.repository.RepositoryMedico;
import com.pgpp.service.MedicoService;

@ExtendWith(MockitoExtension.class)
public class MedicoServiceTest {

    @Mock
    RepositoryMedico repositoryMedico;

    @InjectMocks
    private MedicoService medicoService;

    @Test
    @DisplayName("Comprueba que validarMedico devuelve true si credenciales son correctas")
    public void validarMedico_credencialesCorrectas_devuelveTrue() {
        // Arrange
        String dni = "123A";
        String pass = "secret";
        Medico medico = new Medico();
        medico.setDni(dni);
        medico.setPassword(pass);

        when(repositoryMedico.findById(dni)).thenReturn(Optional.of(medico));

        // Act
        boolean esValido = medicoService.validarMedico(dni, pass);

        // Assert
        assertTrue(esValido);
        verify(repositoryMedico).findById(dni);
    }

    @Test
    @DisplayName("Comprueba que validarMedico devuelve false si password es incorrecto")
    public void validarMedico_passwordIncorrecto_devuelveFalse() {
        // Arrange
        String dni = "123A";
        Medico medico = new Medico();
        medico.setDni(dni);
        medico.setPassword("correcta");

        when(repositoryMedico.findById(dni)).thenReturn(Optional.of(medico));

        // Act
        boolean esValido = medicoService.validarMedico(dni, "incorrecta");

        // Assert
        assertFalse(esValido);
        verify(repositoryMedico).findById(dni);
    }
}