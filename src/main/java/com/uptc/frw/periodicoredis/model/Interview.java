package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Entrevista")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrevista")
    private long id;  // llave artificial presente en oracle tambien

    public Interview() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                '}';
    }
}
