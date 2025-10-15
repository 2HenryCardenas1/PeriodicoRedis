package com.uptc.frw.periodicoredis.model;

import jakarta.persistence.*;

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
