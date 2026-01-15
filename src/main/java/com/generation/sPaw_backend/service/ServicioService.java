package com.generation.sPaw_backend.service;


import com.generation.sPaw_backend.model.Servicio;
import com.generation.sPaw_backend.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService implements IServicioService {

    private final IServicioRepository servicioRepository;

    @Autowired
    public ServicioService(IServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public List<Servicio> obtenerTodos() {
        return servicioRepository.findAll();
    }


    @Override
    public Optional<Servicio> obetenerPorId(Long id) {
//        Servicio servicio = servicioRepository.findById(id)
//                    .orElseThrow();
//
//        return Optional.of(servicio);
        return servicioRepository.findById(id);
    }

    @Override
    public Servicio guardarServico(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

}