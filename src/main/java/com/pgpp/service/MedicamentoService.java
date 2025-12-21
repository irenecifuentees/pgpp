package com.pgpp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Importación necesaria para buscar por ID de forma segura
import org.springframework.stereotype.Service;

import com.pgpp.model.Medicamento;
import com.pgpp.repository.RepositoryMedicamento;

@Service
public class MedicamentoService {
    

    @Autowired
    private RepositoryMedicamento repositoryMedicamento;

    // Devuelve todos los medicamentos 
    public List<Medicamento> getAllMedicamentos() {
        return repositoryMedicamento.findAll();
    }

    // Devuelve un medicamento por ID
    public Medicamento getMedicamento(Long id) {
        return repositoryMedicamento.getReferenceById(id);
    }
    


    // Crea medicamento
    public Medicamento createMedicamento(Medicamento med) {
        return repositoryMedicamento.saveAndFlush(med);
    }
    
   

    // Actualiza un medicamento (se espera el objeto con el ID existente)
    public void updateMedicamento(Medicamento med) {
        Medicamento medicamento = repositoryMedicamento.getReferenceById(med.getIdMedicamento());
        medicamento.setNombre(med.getNombre());
        medicamento.setPrActivo(med.getPrActivo());
        medicamento.setVulnAnciano(med.getVulnAnciano());
        repositoryMedicamento.save(medicamento);
    }
    


    // Elimina un medicamento 
    public void removeMedicamento(Medicamento med) {
        repositoryMedicamento.delete(med);
    }

    // Elimina un medicamento por ID 
    public void deleteMedicamento(Long id) {
         repositoryMedicamento.deleteById(id);
    }
}