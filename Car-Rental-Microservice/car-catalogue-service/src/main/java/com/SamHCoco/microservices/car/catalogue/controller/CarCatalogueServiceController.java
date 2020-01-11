package com.SamHCoco.microservices.car.catalogue.controller;

import com.SamHCoco.microservices.car.catalogue.model.Car;
import com.SamHCoco.microservices.car.catalogue.model.Cars;
import com.SamHCoco.microservices.car.catalogue.service.CarCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarCatalogueServiceController {

    @Autowired
    private CarCatalogueService carCatalogueService;

    /**
     * Returns all rental cars in the rental car database.
     * @return All cars in the rental cars database, with HTTP status OK 200
     * if the request was successful.
     */
    @GetMapping("api/cars/all")
    public ResponseEntity<Cars> getAllCars(){
        List<Car> allCars = carCatalogueService.getAllCars();
        Cars cars = new Cars(allCars);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    /**
     * Returns all the rental cars in the database based on their the geographic location
     * specified by the endpoint.
     * @param location The search location for available rental cars.
     * @return HTTP status 200 (OK) and a Cars object containing all the cars available in the
     * specified geographic location, or HTTP status 404 (NOT FOUND) if no rental
     * cars were found in the specified location.
     */
    @GetMapping("api/cars/{location}")
    public ResponseEntity<Cars> getAllCarsByLocation(@PathVariable String location){
        Optional<List<Car>> optional = carCatalogueService.getAllCarsByLocation(location);

        if(optional.isPresent()){
            Cars cars = new Cars(optional.get());
            return new ResponseEntity<>(cars, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Adds a list of car objects to the rental car database.
     * @param cars The list of cars to be added to the database of rental cars.
     * @return HTTP status 200 (OK) if the cars were successfully added to the database, HTTP status 400
     * (BAD REQUEST) otherwise.
     */
    @PostMapping("api/cars")
    public ResponseEntity addRentalCars(@RequestBody List<Car> cars){
        boolean added = carCatalogueService.addRentalCars(cars);
        if(added){
            return new ResponseEntity(HttpStatus.OK);
        } else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
