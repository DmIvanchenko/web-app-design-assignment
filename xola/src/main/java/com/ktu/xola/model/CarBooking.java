package com.ktu.xola.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "CarBooking")
public class CarBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "userId")
    private int userId;
    @Column(name = "checkIn")
    private Date checkIn;
    @Column(name = "checkOut")
    private Date checkOut;

    @JoinColumn(name = "carId")
    private int carId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return userId;
    }

    public void setUser(int user) {
        this.userId = user;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getCar() {
        return carId;
    }

    public void setCar(int car) {
        this.carId = car;
    }
}
