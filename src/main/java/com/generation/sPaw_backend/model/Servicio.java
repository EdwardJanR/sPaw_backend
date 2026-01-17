package com.generation.sPaw_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private Long idServicio;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name = "precioTamPequeno", nullable = false)
    private Double precioTamPequeno;

    @Column(name = "precioTamMediano", nullable = false)
    private Double precioTamMediano;

    @Column(name = "precioTamGrande", nullable = false)
    private Double precioTamGrande;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonManagedReference
    @JsonIgnoreProperties("servicio")
    private List<Reserva> reservas = new ArrayList<>();

    public Servicio() {}

    public Servicio(String nombre, String descripcion, Double precioTamPequeno,
                    Double precioTamMediano, Double precioTamGrande) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioTamPequeno = precioTamPequeno;
        this.precioTamMediano = precioTamMediano;
        this.precioTamGrande = precioTamGrande;
    }

    // Getters y Setters
    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioTamPequeno() {
        return precioTamPequeno;
    }

    public void setPrecioTamPequeno(Double precioTamPequeno) {
        this.precioTamPequeno = precioTamPequeno;
    }

    public Double getPrecioTamMediano() {
        return precioTamMediano;
    }

    public void setPrecioTamMediano(Double precioTamMediano) {
        this.precioTamMediano = precioTamMediano;
    }

    public Double getPrecioTamGrande() {
        return precioTamGrande;
    }

    public void setPrecioTamGrande(Double precioTamGrande) {
        this.precioTamGrande = precioTamGrande;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}