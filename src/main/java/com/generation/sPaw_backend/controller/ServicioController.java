package com.generation.sPaw_backend.controller;

import com.generation.sPaw_backend.model.Servicio;
import com.generation.sPaw_backend.service.IServicioService;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public Servicio obtenerServicio(@PathVariable Long id) {
        return servicioService.obtenerPorId(id).orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
    }

    @PostMapping("/crear")
    public Servicio crearServicio(@RequestBody Servicio servicio) {
        return servicioService.guardarServico(servicio);
    }


    @PutMapping("{id}")
    public ResponseEntity<Servicio> actualizar(@PathVariable Long id, @RequestBody Servicio servicio) {
        try {
            // Asumiendo que agregas un método actualizarServicio en el servicio
            servicioService.actualizarServicio(id, servicio);
            return ResponseEntity.ok(servicio);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            servicioService.eliminarServicio(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}