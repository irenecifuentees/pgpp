package com.pgpp.service;

import java.util.List;
import com.pgpp.model.Medicamento;
import com.pgpp.repository.RepositoryMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {
   
    @Autowired
    private RepositoryMedicamento repositoryMedicamento;
    public List<Medicamento> getAllMedicamentos() {
        return repositoryMedicamento.findAll();
    }

    //Crear un nuevo medicamento con saveAndFlush
    public Medicamento createMedicamento(Medicamento med) {
        return repositoryMedicamento.saveAndFlush(med);
    }
    
}
