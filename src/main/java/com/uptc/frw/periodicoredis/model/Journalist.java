package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Periodista")
public class Journalist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodista")
    private long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "direccion")
    private String address;
    @Column(name = "telefono")
    private long phone;
    @Column(name = "num_notic")
    private int numNew;
    //Relacion con entrevistas
    @OneToMany(mappedBy = "journalist", cascade = CascadeType.ALL)
    private List<Interview> interviews;

    //Relacion con noticias (tabla intermedia Quien_cubre)
    @ManyToMany
    @JoinTable(
            name = "Quien_cubre",
            joinColumns = @JoinColumn(name = "id_periodista"),
            inverseJoinColumns = @JoinColumn(name = "id_noticia")
    )
    private List<New> newsCovered;


    public Journalist() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumNew() {
        return numNew;
    }

    public void setNumNew(int numNew) {
        this.numNew = numNew;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Journalist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", numNew=" + numNew +
                '}';
    }
}
