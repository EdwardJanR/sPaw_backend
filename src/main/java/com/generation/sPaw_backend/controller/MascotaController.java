package com.generation.sPaw_backend.controller;

import com.generation.sPaw_backend.model.Mascota;
import com.generation.sPaw_backend.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
//@CrossOrigin(origins = "*")
public class MascotaController {
	
	private final IMascotaService mascotaService;
	
	@Autowired
	public MascotaController(IMascotaService mascotaService) {
		this.mascotaService = mascotaService;
	}
	
	// GET - Listar todas las mascotas
	@GetMapping
	public ResponseEntity<List<Mascota>> listarTodas() {
		List<Mascota> mascotas = mascotaService.obtenerTodasMascotas();
		return ResponseEntity.ok(mascotas);
	}
	
	// GET - Obtener una mascota por ID
	@GetMapping("/{id}")
	public ResponseEntity<Mascota> obtenerPorId(@PathVariable Long id) {
		Mascota mascota = mascotaService.obtenerMascotaPorId(id)
				                  .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
		return ResponseEntity.ok(mascota);
	}
	
	// GET - Buscar mascotas por nombre
	@GetMapping("/buscar/nombre/{nombre}")
	public ResponseEntity<List<Mascota>> buscarPorNombre(@PathVariable String nombre) {
		List<Mascota> mascotas = mascotaService.buscarPorNombre(nombre);
		return ResponseEntity.ok(mascotas);
	}
	
	
	// POST - Crear una nueva mascota (sin usuario asignado)
	@PostMapping
	public ResponseEntity<Mascota> crear(@RequestBody Mascota mascota) {
		Mascota mascotaGuardada = mascotaService.guardarMascota(mascota);
		return ResponseEntity.status(HttpStatus.CREATED).body(mascotaGuardada);
	}
}
