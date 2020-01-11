package com.SamHCoco.microservices.car.catalogue.service;

import com.SamHCoco.microservices.car.catalogue.model.Car;
import com.SamHCoco.microservices.car.catalogue.repository.CarCatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarCatalogueService {

    @Autowired
    private CarCatalogueRepository carCatalogueRepository;

    /**
     * Returns all the rental cars in the database.
     * @return List of all cars in the rental cars database.
     */
    public List<Car> getAllCars(){
        List<Car> cars = new ArrayList<>();
        carCatalogueRepository.findAll().forEach(cars::add);
        return cars;
    }

    /**
     * Returns all the rental cars in the database which are available
     * in the specified geographic location.
     * @param location The search location
     * @return List of of all rental cars available in the specified location.
     */
    public Optional<List<Car>> getAllCarsByLocation(String location){
        return carCatalogueRepository.findAllByLocation(location);
    }

    /**
     * Adds cars to the rental car database.
     * @param cars The car(s) to be added to the database.
     * @return True if the car(s) were successfully added, false otherwise.
     */
    public boolean addRentalCars(List<Car> cars){
        boolean added = false;
        carCatalogueRepository.saveAll(cars);

        if(getAllCars().containsAll(cars)){
            added = true;
        }
        return added;
    }
}
