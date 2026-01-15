package com.generation.sPaw_backend.service;


import com.generation.sPaw_backend.model.Servicio;
import com.generation.sPaw_backend.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicioService implements IServicioService {

    private final IServicioRepository servicioRepository;

    @Autowired
    public ServicioService(IServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public List<Servicio> obtenerTodos() {
        return List.of();
    }

    @Override
    public Optional<Servicio> obetenerPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Servicio guardarServico(Servicio servicio) {
        return servicioRepository.save(servicio);
    }


}