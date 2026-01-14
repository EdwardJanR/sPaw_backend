package com.generation.sPaw_backend.repository;

import com.generation.sPaw_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
