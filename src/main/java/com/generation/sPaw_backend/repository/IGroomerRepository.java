package com.generation.sPaw.repository;

import com.generation.sPaw_backend.model.Groomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroomerRepository extends JpaRepository <Groomer, Long> {
}
