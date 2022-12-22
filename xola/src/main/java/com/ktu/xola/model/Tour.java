package com.ktu.xola.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "Tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="tourName")

    private String tourName;
    @Column(name="price")

    private int price;

    @JoinColumn(name = "tourAgencyId")
    private int tourAgencyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTourAgency() {
        return tourAgencyId;
    }

    public void setTourAgency(int tourAgency) {
        this.tourAgencyId = tourAgency;
    }
}
