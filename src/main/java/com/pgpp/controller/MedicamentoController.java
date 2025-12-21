package com.pgpp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgpp.model.Medicamento;
import com.pgpp.service.MedicamentoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
// Se puede añadir un prefijo de mapeo a nivel de clase para simplificar las URLs:
// @RequestMapping("/api/v1") 
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    /*---Añade un nuevo medicamento al sistema y vuelve a la pantalla de listar---*/
    @PostMapping(value = "/medicamento", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<?> saveMedicamento(@ModelAttribute("medicamento") Medicamento medicamento, HttpServletResponse response) {
        try {
            medicamentoService.createMedicamento(medicamento);
            response.sendRedirect("/listMedicamento");
            return ResponseEntity.ok().body("Medicamento creado correctamente");
        } catch (IOException er) {
            return ResponseEntity.status(500).body("Error creando el medicamento: " + er.getMessage());
        }
    }


    /*---Actualiza un medicamento del sistema y vuelve a la pantalla de listar---*/
    @PutMapping(value = "/medicamento", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<?> updateMedicamento(@ModelAttribute("medicamento") Medicamento medicamento, HttpServletResponse response) {
        try {
            // El servicio espera el objeto con el ID ya seteado (viene en el ModelAttribute)
            medicamentoService.updateMedicamento(medicamento);
            response.sendRedirect("/listMedicamento");
            return ResponseEntity.ok().body("Medicamento actualizado correctamente");
        } catch (IOException er) {
            return ResponseEntity.status(500).body("Error actualizando el medicamento: " + er.getMessage());
        }
    } 

    /*---Elimina un medicamento a partir de su ID y vuelve a la pantalla de listar---*/
    @DeleteMapping("/medicamento/{id}")
    public ResponseEntity<?> deleteMedicamento(@PathVariable("id") Long id, HttpServletResponse response) {
        try {
            medicamentoService.deleteMedicamento(id);
            response.sendRedirect("/listMedicamento");
            return ResponseEntity.ok().body("Medicamento eliminado correctamente");
        } catch (IOException er) {
            return ResponseEntity.status(500).body("Error eliminando el medicamento: " + er.getMessage());
        }
    }
}