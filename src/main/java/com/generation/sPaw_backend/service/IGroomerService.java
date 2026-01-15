package com.generation.sPaw_backend.service;

import com.generation.sPaw_backend.model.Groomer;

import java.util.List;
import java.util.Optional;

public interface IGroomerService {
    List<Groomer> listar();
    Optional<Groomer> buscarPorId(Long id);
    Groomer guardar(Groomer groomer);

    void eliminar(Long id);
}
