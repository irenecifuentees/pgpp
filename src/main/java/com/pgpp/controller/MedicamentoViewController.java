package com.pgpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pgpp.model.Medicamento;
import com.pgpp.service.MedicamentoService;

@Controller
public class MedicamentoViewController {

    @Autowired
    private MedicamentoService medicamentoService;

    /*---Devuelve el formulario de index (puedes cambiar "indexM" por tu vista principal)---*/
    @GetMapping("/")
    public String indexMedicamentoView() {
        return "indexM"; 
    }

    /*---Devuelve el formulario para añadir un nuevo medicamento con un objeto vacío---*/
    @GetMapping("/addMedicamento")
    public String addMedicamentoView(Model model) {
        model.addAttribute("medicamento", new Medicamento());
        return "addMedicamento";
    }

    /*---Devuelve el formulario para listar los medicamentos del sistema---*/
    @GetMapping("/listMedicamento")
    public String listMedicamentoView(Model model) {
        model.addAttribute("medicamentos", medicamentoService.getAllMedicamentos());
        return "listMedicamento";
    }

    /*---Devuelve el formulario para editar un Medicamento---*/
    @GetMapping("/editMedicamento/{id}")
    public String editMedicamentoView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("medicamento", medicamentoService.getMedicamento(id));
        return "updateMedicamento";
    }
}