package com.generation.sPaw.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Groomer")
public class Groomer {
    @Id
    Private Long id;
    @Column(
            name = "titulo", length = 300;
    )
}
