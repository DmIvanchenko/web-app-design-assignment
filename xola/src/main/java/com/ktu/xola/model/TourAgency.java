package com.ktu.xola.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "TourAgency")
public class TourAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")

    private String name;

    @JoinColumn(name = "cityId")
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCity() {
        return cityId;
    }

    public void setCity(int city) {
        this.cityId = city;
    }
}
