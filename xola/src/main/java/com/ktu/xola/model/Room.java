package com.ktu.xola.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="numberOfGuests")

    private int numberOfGuests;
    @JoinColumn(name = "hotelId")
    private int hotelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getHotel() {
        return hotelId;
    }

    public void setHotel(int hotel) {
        this.hotelId = hotel;
    }
}
