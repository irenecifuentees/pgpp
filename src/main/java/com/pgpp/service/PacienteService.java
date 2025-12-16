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

    // Listar todos los pacientes
    public List<Paciente> getAllPacientes() {
        return repoPaciente.findAll();
    }

    // Buscar paciente por DNI
    public Paciente getPacienteByDni(String dni) {
        return repoPaciente.findById(dni).orElse(null);
    }

    // --- MÉTODO PRINCIPAL: PRESCRIBIR ---
    public void prescribirMedicamento(String dniPaciente, Long idMedicamento) {
        // 1. Buscamos el paciente por DNI
        Paciente paciente = repoPaciente.findById(dniPaciente).orElse(null);
        
        // 2. Buscamos el medicamento por ID (asumiendo que es Long en Medicamento)
        Medicamento medicamento = repoMedicamento.findById(idMedicamento).orElse(null);

        // 3. Si ambos existen, los asociamos y guardamos
        if (paciente != null && medicamento != null) {
            paciente.agregarMedicamento(medicamento);
            repoPaciente.save(paciente); // Guardar actualiza la tabla intermedia
        }
    }
}