package com.ktu.xola.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "price")
    private int price;
    @Column(name = "carModel")
    private String carModel;
    @JoinColumn(name = "carAgencyId")
    private int carAgencyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarAgency() {
        return carAgencyId;
    }

    public void setCarAgency(int carAgency) {
        this.carAgencyId = carAgency;
    }
}
