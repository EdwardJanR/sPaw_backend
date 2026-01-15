package com.generation.sPaw_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascota")
    private Long idMascota;

    @Column(name = "nombreMascota", length = 50)
    private String nombreMascota;

    @ManyToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "FK_MASCOTA_USUARIO"))
    @JsonBackReference
    private Usuario usuario;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Reserva> reservas;

    public Mascota() {}

    public Mascota(String nombreMascota, Usuario usuario) {
        this.nombreMascota = nombreMascota;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}