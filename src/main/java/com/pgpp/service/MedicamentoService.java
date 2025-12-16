package com.pgpp.service;

import java.util.List;
import java.util.Optional; // Importación necesaria para buscar por ID de forma segura

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgpp.model.Medicamento;
import com.pgpp.repository.RepositoryMedicamento;

@Service
public class MedicamentoService {
    
    // Inyección de dependencias para el repositorio [cite: 487]
    @Autowired
    private RepositoryMedicamento repositoryMedicamento;
    
    // ---------------------- READ (Leer) ----------------------

    // Devuelve todos los medicamentos (uso de findAll() de JpaRepository) [cite: 466]
    public List<Medicamento> getAllMedicamentos() {
        return repositoryMedicamento.findAll();
    }

    // Devuelve un medicamento por ID (uso de getReferenceById() o findById()) [cite: 467]
    public Medicamento getMedicamentoById(Long id) {
        // Opción 1: Usar getReferenceById() (similar a la referencia de CuentaService)
        // return repositoryMedicamento.getReferenceById(id);
        
        // Opción 2: Usar findById() para un manejo de errores más seguro con Optional
        Optional<Medicamento> medicamento = repositoryMedicamento.findById(id);
        return medicamento.orElse(null); // Devuelve el medicamento o null si no existe
    }
    
    // ---------------------- CREATE (Crear) ----------------------

    // Crea un nuevo medicamento (uso de saveAndFlush() de JpaRepository) [cite: 468]
    public Medicamento createMedicamento(Medicamento med) {
        return repositoryMedicamento.saveAndFlush(med);
    }
    
    // ---------------------- UPDATE (Actualizar) ----------------------

    // Actualiza un medicamento (se espera el objeto con el ID existente)
    public Medicamento updateMedicamento(Long id, Medicamento medDetails) {
        Optional<Medicamento> optionalMedicamento = repositoryMedicamento.findById(id);
        
        if (optionalMedicamento.isPresent()) {
            Medicamento existingMedicamento = optionalMedicamento.get();
            
            // Actualización de los campos específicos de Medicamento
            existingMedicamento.setNombre(medDetails.getNombre());
            existingMedicamento.setPrActivo(medDetails.getPrActivo());
            
            // Guardar el objeto actualizado
            return repositoryMedicamento.save(existingMedicamento);
        } else {
            // Se podría lanzar una excepción o devolver null
            return null;
        }
    }
    
    // ---------------------- DELETE (Eliminar) ----------------------

    // Elimina un medicamento pasando el objeto (uso de delete() de JpaRepository) [cite: 469]
    public void removeMedicamento(Medicamento med) {
        repositoryMedicamento.delete(med);
    }

    // Elimina un medicamento por ID (uso de deleteById() de JpaRepository)
    public boolean deleteMedicamento(Long id) {
         if (repositoryMedicamento.existsById(id)) {
            repositoryMedicamento.deleteById(id);
            return true;
        }
        return false;
    }
}