package com.pgpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pgpp.service.MedicamentoService;
import com.pgpp.service.PacienteService;

@Controller
public class PrescripcionController {

    @Autowired
    private PacienteService pacienteService;
    
    @Autowired
    private MedicamentoService medicamentoService;

    // Paso 1: Mostrar la pantalla de prescripción con los desplegables
    @GetMapping("/prescribir")
    public String vistaPrescribir(Model model) {
        model.addAttribute("pacientes", pacienteService.getAllPacientes());
        model.addAttribute("medicamentos", medicamentoService.getAllMedicamentos());
        return "formPrescripcion"; // Nombre del archivo HTML
    }

    // Paso 2: Recibir los datos y guardarlos
    @PostMapping("/prescribir/guardar")
    public String guardarPrescripcion(
            @RequestParam("dniPaciente") String dniPaciente, // Recibe String
            @RequestParam("idMedicamento") Long idMedicamento // Recibe Long
    ) {
        pacienteService.prescribirMedicamento(dniPaciente, idMedicamento);
        
        // Redirigir al usuario (por ejemplo, a la lista de medicamentos o al inicio)
        return "redirect:/listMedicamento"; 
    }
}