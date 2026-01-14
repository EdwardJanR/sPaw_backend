package com.generation.sPaw_backend.service;

import com.generation.sPaw_backend.model.Mascota;
import java.util.List;
import java.util.Optional;

public interface IMascotaService {
	List<Mascota> obtenerTodasMascotas();
	
	Optional<Mascota> obtenerMascotaPorId(Long id);
	Mascota guardarMascota(Mascota mascota);
	
	List<Mascota> buscarPorNombre(String nombreMascota);
}