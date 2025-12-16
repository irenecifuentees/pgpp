package com.pgpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pgpp.model.Paciente;
import com.pgpp.service.MedicamentoService;
import com.pgpp.service.PacienteService;

@Controller
public class PrescripcionController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MedicamentoService medicamentoService;

    // 1. Formulario inicial
    @GetMapping("/prescribir")
    public String vistaPrescribir(Model model) {
        model.addAttribute("pacientes", pacienteService.getAllPacientes());
        model.addAttribute("medicamentos", medicamentoService.getAllMedicamentos());
        // Debe existir templates/formPrescripcion.html
        return "formPrescripcion"; 
    }

    // 2. Guardar y Redirigir
    @PostMapping("/prescribir/guardar")
    public String guardarPrescripcion(
            @RequestParam("dniPaciente") String dniPaciente,
            @RequestParam("idMedicamento") Long idMedicamento,
            @RequestParam("dniMedico") String dniMedico, 
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes 
    ) {
        boolean exito = pacienteService.prescribirMedicamentoSeguro(dniPaciente, idMedicamento, dniMedico, password);
        
        if (exito) {
            // REDIRECCIÓN CLAVE: Va a la URL del paso 3
            return "redirect:/paciente/" + dniPaciente + "/tratamientos";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error: DNI médico no existe o contraseña incorrecta.");
            return "redirect:/prescribir";
        }
    }

    // 3. Ver tratamientos de UN paciente
    @GetMapping("/paciente/{dni}/tratamientos")
    public String verTratamientosPaciente(@PathVariable("dni") String dni, Model model) {
        Paciente paciente = pacienteService.getPaciente(dni);
        
        if (paciente == null) {
            // Si el DNI no existe, volvemos a prescribir para evitar error
            return "redirect:/prescribir"; 
        }

        model.addAttribute("paciente", paciente);
        // Debe existir templates/listTratamientosPaciente.html
        return "listTratamientosPaciente"; 
    }
    
    // Listado general (opcional)
    @GetMapping("/listPacientesConTratamientos")
    public String listPrescripcionesView(Model model) {
        model.addAttribute("pacientes", pacienteService.getAllPacientes());
        return "listPrescripciones";
    }
}