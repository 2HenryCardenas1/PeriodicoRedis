package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Agencia")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agencia")
    private  long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "anio_creacion")
    private Integer creationYear;
    //Relacion con AgNew (N:1)
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<AgNew> agNews;

    public Agency() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(Integer creationYear) {
        this.creationYear = creationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationYear=" + creationYear +
                '}';
    }
}
