package com.SamHCoco.microservices.car.catalogue.repository;

import com.SamHCoco.microservices.car.catalogue.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarCatalogueRepository extends CrudRepository<Car, Integer> {
    /**
     * Finds all cars available by location.
     * @return Optional object of Cars, available by location.
     */
    Optional<List<Car>> findAllByLocation(String location);
}
