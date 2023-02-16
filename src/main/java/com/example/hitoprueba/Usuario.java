package com.example.hitoprueba;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "nif")
    private String nif;

    @Column(name = "activo")
    private int activo;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pw")
    private String pw;

    @Column(name = "rol")
    private String rol;

}
