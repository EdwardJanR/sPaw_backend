package com.generation.sPaw_backend.repository;

import com.generation.sPaw_backend.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMascotaRepository extends JpaRepository<Mascota, Long> {
}
