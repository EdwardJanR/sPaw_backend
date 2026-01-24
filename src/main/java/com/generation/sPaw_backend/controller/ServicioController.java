package com.generation.sPaw_backend.controller;

import com.generation.sPaw_backend.model.Servicio;
import com.generation.sPaw_backend.service.IServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @PostMapping("/crearConImagen")
    public ResponseEntity<?> crearServicioConImagen(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precioTamPequeno") Double precioTamPequeno,
            @RequestParam("precioTamMediano") Double precioTamMediano,
            @RequestParam("precioTamGrande") Double precioTamGrande,
            @RequestParam(value = "imagen", required = false) MultipartFile imagen) {

        try {
            Servicio servicio = new Servicio();
            servicio.setNombre(nombre);
            servicio.setDescripcion(descripcion);
            servicio.setPrecioTamPequeno(precioTamPequeno);
            servicio.setPrecioTamMediano(precioTamMediano);
            servicio.setPrecioTamGrande(precioTamGrande);

            if (imagen != null && !imagen.isEmpty()) {
                servicio.setImagen(imagen.getBytes());
            }

            Servicio guardado = servicioService.guardarServico(servicio);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear servicio: " + e.getMessage());
        }
    }

    @PutMapping("/actualizarConImagen/{id}")
    public ResponseEntity<?> actualizarConImagen(
            @PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precioTamPequeno") Double precioTamPequeno,
            @RequestParam("precioTamMediano") Double precioTamMediano,
            @RequestParam("precioTamGrande") Double precioTamGrande,
            @RequestParam(value = "imagen", required = false) MultipartFile imagen) {

        try {
            Servicio servicio = servicioService.obtenerPorId(id)
                    .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

            servicio.setNombre(nombre);
            servicio.setDescripcion(descripcion);
            servicio.setPrecioTamPequeno(precioTamPequeno);
            servicio.setPrecioTamMediano(precioTamMediano);
            servicio.setPrecioTamGrande(precioTamGrande);

            if (imagen != null && !imagen.isEmpty()) {
                servicio.setImagen(imagen.getBytes());
            }

            Servicio actualizado = servicioService.guardarServico(servicio);
            return ResponseEntity.ok(actualizado);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar servicio: " + e.getMessage());
        }
    }


    @DeleteMapping("/eliminar/{id}")
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