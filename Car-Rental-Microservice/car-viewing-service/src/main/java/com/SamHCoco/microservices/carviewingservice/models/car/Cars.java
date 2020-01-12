package com.SamHCoco.microservices.carviewingservice.models.car;

import java.util.List;

public class Cars {

    public Cars(){

    }

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
