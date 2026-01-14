package com.generation.sPaw_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="mascota")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMascota;
	
	@Column(nullable = false)
	private String nombreMascota;
	
	// Constructores
	public Mascota() {
	}
	
	public Mascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	
	// Getters y Setters
	public Long getIdMascota() {
		return idMascota;
	}
	
	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}
	
	public String getNombreMascota() {
		return nombreMascota;
	}
	
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
}