package com.generation.sPaw_backend.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Groomer")
public class Groomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGroomer")
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100, unique = true)
    private String email;


    public Long getIdGroomer() {
        return id;
    }

    public void setIdGroomer(Long idGroomer) {
        this.id = idGroomer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


