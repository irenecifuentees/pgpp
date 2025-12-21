package com.pgpp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgpp.model.Medicamento;
import com.pgpp.model.Paciente;
import com.pgpp.repository.RepositoryMedicamento;
import com.pgpp.repository.RepositoryPaciente;

@Service
public class PacienteService {

    @Autowired
    private RepositoryPaciente repoPaciente;
    @Autowired
    private RepositoryMedicamento repoMedicamento;
    @Autowired
    private MedicoService medicoService; 

    public List<Paciente> getAllPacientes() {
        return repoPaciente.findAll();
    }
    
    // Método necesario para la vista individual
    public Paciente getPaciente(String dni) {
        return repoPaciente.findById(dni).orElse(null);
    }

    public boolean prescribirMedicamentoSeguro(String dniPaciente, Long idMedicamento, String dniMedico, String password) {
        // 1. Validar Médico
        if (!medicoService.validarMedico(dniMedico, password)) {
            return false;
        }
        // 2. Validar Paciente y Medicamento
        Paciente paciente = repoPaciente.findById(dniPaciente).orElse(null);
        Medicamento medicamento = repoMedicamento.findById(idMedicamento).orElse(null);

        if (paciente != null && medicamento != null) {
            // Evitar duplicados
            if (!paciente.getTratamientos().contains(medicamento)) {
                paciente.agregarMedicamento(medicamento);
                repoPaciente.save(paciente);
            }
            return true;
        }
        return false; 
    }
}