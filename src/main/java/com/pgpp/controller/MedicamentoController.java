package com.pgpp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pgpp.model.Medicamento;
@RestController


public class MedicamentoController {

    @Autowired

    private com.pgpp.service.MedicamentoService medicamentoService;
    
    @GetMapping("/medicamentos")
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoService.getAllMedicamentos();
    }

    @PostMapping("/medicamento")
    public ResponseEntity<?> addMedicamento(@RequestBody Medicamento med) {
        try{
            medicamentoService.createMedicamento(med);
            return ResponseEntity.ok().body("Un nuevo medicamento se ha anyadido");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("El medicamento ya existe");
        }
    
}
    
}