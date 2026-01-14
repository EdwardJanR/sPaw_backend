package com.generation.sPaw_backend.service;

import com.generation.sPaw_backend.model.Mascota;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {
	List<Mascota> obtenerTodoMascota();
	Optional<Mascota> obtenerMascotaPorId(Long id);
	void guardarMascota(Mascota mascota);
}
