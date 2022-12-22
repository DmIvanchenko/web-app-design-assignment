package com.ktu.xola.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "User_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="firstName")

    private String firstName;
    @Column(name="lastName")

    private String lastName;
    @Email
    @Column(name="email")
    private String email;
    @Column(name="password")

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
