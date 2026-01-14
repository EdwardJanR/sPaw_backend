package com.generation.sPaw_backend.service;

import com.generation.sPaw_backend.model.Mascota;
import com.generation.sPaw_backend.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {
	
	private final IMascotaRepository mascotaRepository;
	
	@Autowired
	public MascotaService(IMascotaRepository mascotaRepository) {
		this.mascotaRepository = mascotaRepository;
	}
	
	@Override
	public List<Mascota> obtenerTodasMascotas() {
		return mascotaRepository.findAll();
	}
	
	@Override
	public Optional<Mascota> obtenerMascotaPorId(Long id) {
		return mascotaRepository.findById(id);
	}
	
	@Override
	public Mascota guardarMascota(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}
	
	@Override
	public List<Mascota> buscarPorNombre(String nombreMascota) {
		return mascotaRepository.findByNombreMascotaContainingIgnoreCase(nombreMascota);
	}
}