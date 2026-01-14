package com.generation.sPaw_backend.repository;

import com.generation.sPaw_backend.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long> {
	
	// Buscar mascotas por nombre
	List<Mascota> findByNombreMascotaContainingIgnoreCase(String nombreMascota);
	
	// Verificar si existe una mascota con ese nombre
	boolean existsByNombreMascota(String nombreMascota);
}