package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Implicado_noticia")
public class ImplicatedNew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // llave artificial
    @Column(name = "rol")
    private String rol;

    public ImplicatedNew() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "ImplicatedNew{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                '}';
    }
}
