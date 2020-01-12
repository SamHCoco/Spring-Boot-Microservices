package com.SamHCoco.microservices.carviewingservice.service;

import com.SamHCoco.microservices.carviewingservice.models.car.Cars;
import com.SamHCoco.microservices.carviewingservice.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ViewingService {

    @Autowired
    private RestTemplate restTemplate;

    public Optional<User> getUserDetails(String userName){
        User user = restTemplate.getForObject("http://user-service/api/users/" + userName, User.class);
        return Optional.of(user);
    }

    public Optional<Cars> getAllCarsInLocation(String location){
        Cars cars = restTemplate.getForObject("http://car-catalogue-service/api/cars/" + location, Cars.class);
        return Optional.of(cars);
    }

    public Optional<Cars> getAllCarsInUserLocation(String userName){
        Optional<User> user = getUserDetails(userName);
        Optional<Cars> cars = Optional.empty();

        if(user.isPresent()){
            cars = getAllCarsInLocation(user.get().getAddress().getLocation());
        }
        return cars;
    }
}
