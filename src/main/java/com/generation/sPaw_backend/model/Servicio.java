package com.generation.sPaw_backend.model;

import jakarta.persistence.*;

@Entity
@Table (name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServico;

    @Column(nullable = false)
    private String nombreServicio;

    @Column(nullable = false)
    private String descripcion;


    private Double precioTamPequeno;
    private Double precioTamMediano;
    private Double precioTamGrande;

    public Servicio() {
    }

    public Servicio(Long idServico, String nombreServicio, String descripcion, Double precioTamPequeno, Double precioTamMediano, Double precioTamGrande) {
        this.idServico = idServico;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precioTamPequeno = precioTamPequeno;
        this.precioTamMediano = precioTamMediano;
        this.precioTamGrande = precioTamGrande;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
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
}
