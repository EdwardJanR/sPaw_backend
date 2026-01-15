package com.generation.sPaw_backend.controller;

import com.generation.sPaw_backend.model.Servicio;
import com.generation.sPaw_backend.service.IServicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    private final IServicioService servicioService;

    public ServicioController(IServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public List<Servicio> listaServicios() {
        return servicioService.obtenerTodos();
    }

    @PostMapping("/crear")
    public Servicio crearServicio(@RequestBody Servicio servicio) {
        return servicioService.guardarServico(servicio);
    }

    @GetMapping("/{id}")
    public Servicio obtenerServicio(@PathVariable Long id) {
        return servicioService.obetenerPorId(id).orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
    }

}