package com.pgpp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgpp.model.Medicamento;
import com.pgpp.service.MedicamentoService;

@RestController
// Se puede añadir un prefijo de mapeo a nivel de clase para simplificar las URLs:
// @RequestMapping("/api/v1") 
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;
    

    // Devuelve todos los medicamentos
    @GetMapping("/medicamentos")
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoService.getAllMedicamentos();
    }

    // Devuelve un medicamento por ID 
    @GetMapping("/medicamento/{id}")
    public Medicamento getMedicamento(@PathVariable("id") Long id) {
        return medicamentoService.getMedicamento(id);
    }
    
    // Crea un nuevo medicamento 
    @PostMapping(value = "/medicamento", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addMedicamento(@RequestBody Medicamento med) {
        try {
            medicamentoService.createMedicamento(med);
            return ResponseEntity.ok().body("Un nuevo medicamento se ha anyadido"); 
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("El medicamento ya existe o hubo otro error: " + e.getMessage()); 
        }
    }


    // Crea una cuenta con el objeto Cuenta recibido en formato HTML Form
    @PostMapping(value = "/medicamento", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
    public ResponseEntity<?> saveHTMLMedicamento(Medicamento med) {
        try {
            medicamentoService.createMedicamento(med);
            return ResponseEntity.ok().body("Un nuevo medicamento se ha anyadido"); 
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("El medicamento ya existe o hubo otro error: " + e.getMessage()); 
        }
    }

    
    
    // Actualiza un medicamento 
    @PutMapping("/medicamento")
    public ResponseEntity<?> updateMedicamento (Medicamento med) {
        try{
            medicamentoService.updateMedicamento(med);
            return ResponseEntity.ok().body("El medicamento se ha actualizado");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Error al actualizar el medicamento: " + e.getMessage());
        }
    }
   
    
   
    
    // Elimina un medicamento 
    @DeleteMapping("/medicamento")
    public ResponseEntity<?> deleteMedicamento(@RequestBody Medicamento medicamento){
        try{
            medicamentoService.removeMedicamento(medicamento);
            return ResponseEntity.ok().body("El medicamento se ha eliminado");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Error al eliminar el medicamento");
        }
    }
}