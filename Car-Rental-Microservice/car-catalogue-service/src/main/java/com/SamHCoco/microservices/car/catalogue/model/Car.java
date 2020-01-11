package com.SamHCoco.microservices.car.catalogue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car extends Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private byte seats;
    private byte milesPerGallon;
    private String location;

    public Car(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getSeats() {
        return seats;
    }

    public void setSeats(byte seats) {
        this.seats = seats;
    }

    public byte getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(byte milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
