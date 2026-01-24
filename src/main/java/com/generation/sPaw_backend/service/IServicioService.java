package com.generation.sPaw_backend.service;

import com.generation.sPaw_backend.model.Servicio;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IServicioService {
    List<Servicio> obtenerTodos();
    Optional<Servicio> obtenerPorId(Long id);
    Servicio guardarServico(Servicio servicio);
    Servicio actualizarServicio(Long id, Servicio servicioActualizado);
    void eliminarServicio(Long id);
    Servicio guardarServico(Servicio servicio, MultipartFile imagen) throws IOException;

}