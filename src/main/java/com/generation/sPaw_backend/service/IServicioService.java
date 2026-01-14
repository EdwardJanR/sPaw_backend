package com.generation.sPaw_backend.service;

import com.generation.sPaw_backend.model.Servicio;

import java.util.List;
import java.util.Optional;

public interface IServicioService {
    List<Servicio> obtenerTodos();
    Optional<Servicio> obetenerPorId(Long id);
    void guardarServico(Servicio servicio);
    void deleteServicio(Long id);
    void editarServicio(Long id, Servicio servicioActualizado);
}