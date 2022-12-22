package com.ktu.xola.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "HotelBooking")
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "userId")
    private int userId;
    @Column(name="checkIn")
    private Date checkIn;
    @Column(name="checkOut")
    private Date checkOut;

    @JoinColumn(name = "roomId")
    private int roomId;

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

    public int getRoom() {
        return roomId;
    }

    public void setRoom(int room) {
        this.roomId = room;
    }
}
