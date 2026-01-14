//package com.generation.sPaw_backend.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name="mascota")
//public class Mascota {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idMascota;
//
//	@Column(nullable = false)
//	private String nombreMascota;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "isUsuario")
//	@Column(nullable = false)
//	private Long idUsuario;
//
//	public Mascota() {
//	}
//
//	public Mascota(Long idMascota, String nombreMascota, Long idUsuario) {
//		this.idMascota = idMascota;
//		this.nombreMascota = nombreMascota;
//		this.idUsuario = idUsuario;
//	}
//
//	public Long getIdMascota() {
//		return idMascota;
//	}
//
//	public void setIdMascota(Long idMascota) {
//		this.idMascota = idMascota;
//	}
//
//	public String getNombreMascota() {
//		return nombreMascota;
//	}
//
//	public void setNombreMascota(String nombreMascota) {
//		this.nombreMascota = nombreMascota;
//	}
//
//	public Long getIdUsuario() {
//		return idUsuario;
//	}
//
//	public void setIdUsuario(Long idUsuario) {
//		this.idUsuario = idUsuario;
//	}
//}
