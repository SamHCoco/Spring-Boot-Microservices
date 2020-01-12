package com.SamHCoco.microservices.carviewingservice.controller;

import com.SamHCoco.microservices.carviewingservice.models.car.Cars;
import com.SamHCoco.microservices.carviewingservice.service.ViewingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CarViewingServiceController {

    @Autowired
    private ViewingService viewingService;

    @GetMapping("api/users/{userName}/view-cars")
    public ResponseEntity<Cars> getAllCarsInUserLocation(@PathVariable String userName){
        Optional<Cars> cars = viewingService.getAllCarsInUserLocation(userName);
        if(cars.isPresent()) {
            return new ResponseEntity<>(cars.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
