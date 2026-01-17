package com.generation.sPaw_backend.controller;

import com.generation.sPaw_backend.model.Groomer;
import com.generation.sPaw_backend.service.IGroomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groomers")
@CrossOrigin("*")
public class GroomerController {

    private final IGroomerService groomerService;

    public GroomerController(IGroomerService groomerService) {
        this.groomerService = groomerService;
    }


    @GetMapping
    public ResponseEntity<List<Groomer>> listar() {
        return ResponseEntity.ok(groomerService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Groomer> buscar(@PathVariable Long id) {
        return groomerService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Groomer> crear(@RequestBody Groomer groomer) {
        return ResponseEntity.ok(groomerService.guardar(groomer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Groomer> actualizar(@PathVariable Long id, @RequestBody Groomer groomer) {
        return groomerService.buscarPorId(id)
                .map(g -> {

                    g.setNombre(groomer.getNombre());
                    g.setApellido(groomer.getApellido());
                    g.setTelefono(groomer.getTelefono());
                    g.setEmail(groomer.getEmail());
                    Groomer actualizado = groomerService.guardar(g);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        return groomerService.buscarPorId(id)
                .map(g -> {
                    groomerService.eliminar(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}


