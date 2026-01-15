package com.generation.sPaw_backend.service;

import com.generation.sPaw_backend.model.Groomer;
import com.generation.sPaw_backend.repository.IGroomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroomerService implements IGroomerService {

    private final IGroomerRepository groomerRepository;

    public GroomerService(IGroomerRepository groomerRepository) {
        this.groomerRepository = groomerRepository;
    }

    @Override
    public List<Groomer> listar() {
        return groomerRepository.findAll();
    }

    @Override
    public Optional<Groomer> buscarPorId(Long id) {
        return groomerRepository.findById(id);
    }

    @Override
    public Groomer guardar(Groomer groomer) {
        return groomerRepository.save(groomer);

    }

    public void eliminar(Long id) {
        groomerRepository.deleteById(id);
    }

}