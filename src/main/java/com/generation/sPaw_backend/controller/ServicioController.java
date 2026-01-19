package com.generation.sPaw_backend.controller;

import com.generation.sPaw_backend.model.Servicio;
import com.generation.sPaw_backend.service.IServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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


    @PutMapping("actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Servicio servicio) {
        try {
            Servicio servicioActualizado = servicioService.actualizarServicio(id, servicio);
            return ResponseEntity.ok(servicioActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fallo Actualizacion error: " + e.getMessage());
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            Servicio servicio =  servicioService.obtenerPorId(id).orElseThrow(() -> new RuntimeException("Servicio no fue encontrado"));

            String nombreServicio = servicio.getNombre();

            if (!servicio.getReservas().isEmpty()){
                throw new RuntimeException("No se puede eliminar el servicio " + nombreServicio + ", tiene " + servicio.getReservas().size() + " activas");
            }

            servicioService.eliminarServicio(id);
            return ResponseEntity.ok("El servicio " + nombreServicio + " fue eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar, error: " + e.getMessage());
        }
    }
}