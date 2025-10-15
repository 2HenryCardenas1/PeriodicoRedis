package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "Ag_noticia")
public class AgNew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // llave artificial
    @Column(name = "hora_noticia")
    private LocalTime hourNew;
    // Relaciones N:1
    @ManyToOne
    @JoinColumn(name = "id_agencia")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "id_noticia")
    private New news;

    public AgNew() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHourNew() {
        return hourNew;
    }

    public void setHourNew(LocalTime hourNew) {
        this.hourNew = hourNew;
    }

    @Override
    public String toString() {
        return "AgNew{" +
                "id=" + id +
                ", hourNew=" + hourNew +
                '}';
    }
}


