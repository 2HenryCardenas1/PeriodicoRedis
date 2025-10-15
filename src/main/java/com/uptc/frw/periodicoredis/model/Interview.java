package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Entrevista")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrevista")
    private long id;  // llave artificial presente en oracle tambien

    //Relaciones N:1
    @ManyToOne
    @JoinColumn(name = "id_periodista")
    private Journalist journalist;

    @ManyToOne
    @JoinColumn(name = "id_implicado")
    private Implicated implicated;

    @ManyToOne
    @JoinColumn(name = "id_noticia")
    private New news;

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
