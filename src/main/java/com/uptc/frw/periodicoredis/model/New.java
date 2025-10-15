package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Date;

@Entity
@Table(name = "Noticia")
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private long id;
    @Column(name = "fecha_hora")
    private Date date;
    @Column(name = "titular")
    private String headline;
    @Lob
    @Column(name = "texto")
    private String text;
    //Noticia relacionada consigo misma
    @ManyToOne
    @JoinColumn(name = "id_noticia_relacionada")
    private New relatedNews;

    //Relación con entrevistas
    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    private List<Interview> interviews;

    //Relacion con agencias
    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    private List<AgNew> agNews;

    //Relacion con periodistas (quien_cubre)
    @ManyToMany(mappedBy = "newsCovered")
    private List<Journalist> journalists;

    public New() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "New{" +
                "id=" + id +
                ", date=" + date +
                ", headline='" + headline + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
