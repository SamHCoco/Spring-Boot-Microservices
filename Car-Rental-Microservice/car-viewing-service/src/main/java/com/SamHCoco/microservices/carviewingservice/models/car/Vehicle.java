package com.SamHCoco.microservices.carviewingservice.models.car;

public class Vehicle {

    private String make;
    private String model;

    public Vehicle(){

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
