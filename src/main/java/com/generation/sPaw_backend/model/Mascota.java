package com.generation.sPaw_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMascota;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	@JsonBackReference
	private Usuario dueno;
	
	public Mascota() {}
	
	public Mascota(String nombre, String tipo) {
		this.nombre = nombre;
	}
	
	public Long getId() {
		return idMascota;
	}
	
	public void setId(Long idMascota) {
		this.idMascota = idMascota;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Usuario getDueno() {
		return dueno;
	}
	
	public void setDueno(Usuario dueno) {
		this.dueno = dueno;
	}
}
