package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Noticia")
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private long id;
    @Column(name = "fecha_hora")
    private Date fechaHora;
    @Column(name = "titular")
    private String titular;
    @Lob
    @Column(name = "texto")
    private String texto;

    public New() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "New{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                ", titular='" + titular + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
