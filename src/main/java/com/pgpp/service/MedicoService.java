package com.pgpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgpp.model.Medico;
import com.pgpp.repository.RepositoryMedico;

@Service
public class MedicoService {

    @Autowired
    private RepositoryMedico repoMedico;

    public Medico createMedico(Medico medico) {
        return repoMedico.save(medico);
    }

    // MÉTODO ACTUALIZADO: Busca por DNI (ID)
    public boolean validarMedico(String dni, String password) {
        // Como el DNI es la Clave Primaria, usamos findById
        // orElse(null) devuelve null si no existe ese DNI
        Medico medico = repoMedico.findById(dni).orElse(null);

        if (medico != null && medico.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}