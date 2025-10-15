package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Implicado")
public class Implicated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_implicado")
    private long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "fecha_nacimiento")
    private Date birthDay;

    public Implicated() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Implicated{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
