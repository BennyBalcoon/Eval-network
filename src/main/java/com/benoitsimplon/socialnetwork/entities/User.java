package com.benoitsimplon.socialnetwork.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 256)
    private String email;

    @Column(nullable = false)
    private LocalDate birthdate;

    private Timestamp lastKnownPresence;

    public User() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Timestamp getLastKnownPresence() {
        return lastKnownPresence;
    }

    public void setLastKnownPresence(Timestamp lastKnownPresence) {
        this.lastKnownPresence = lastKnownPresence;
    }
}

