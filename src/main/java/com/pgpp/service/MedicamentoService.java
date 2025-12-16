package com.pgpp.service;

import com.pgpp.model.Medicamento;
import com.pgpp.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository repository;

    public MedicamentoService(MedicamentoRepository repository) {
        this.repository = repository;
    }

    public List<Medicamento> findAll() {
        return repository.findAll();
    }

    public Medicamento findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Medicamento save(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
