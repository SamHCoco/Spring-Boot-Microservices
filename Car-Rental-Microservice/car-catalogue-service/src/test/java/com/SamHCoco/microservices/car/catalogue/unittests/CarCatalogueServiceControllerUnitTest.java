package com.SamHCoco.microservices.car.catalogue.unittests;

import com.SamHCoco.microservices.car.catalogue.controller.CarCatalogueServiceController;
import com.SamHCoco.microservices.car.catalogue.model.Car;
import com.SamHCoco.microservices.car.catalogue.model.Cars;
import com.SamHCoco.microservices.car.catalogue.service.CarCatalogueService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CarCatalogueServiceController.class)
public class CarCatalogueServiceControllerUnitTest {

    @MockBean
    private CarCatalogueService carCatalogueService;

    @Autowired
    private MockMvc mockMvc;  // For performing HTTP requests to controller during testing

    @Autowired
    private ObjectMapper objectMapper; // For converting objects -> JSON, and vice-versa

    private List<Car> cars;   // List of cars simulating the cars in a database, for testing

    /**
     * Sets up fake testing 'database' of cars (actually a list).
     */
    @Before
    public void setup(){
        cars = Arrays.asList(
            new Car(1L, "BMW", "5 Series", (byte) 5, (byte) 45, "South-UK"),
            new Car(2L, "AUDI", "A3", (byte) 5, (byte) 49, "North-UK")
        );

    }

    /**
     * Unit tests of the getAllCars method in the CarCatalogueServiceController, which
     * is supposed to return all cars in the database.
     * @throws Exception 'writeValueAsString()' method of ObjectMapper may throw
     * 'com.fasterxml.jackson.core.JsonProcessingException',
     * or 'perform()' method of MockMvc may throw 'java.lang.Exception'
     */
    @Test
    public void getAllCarsTest() throws Exception {
        String expectedResponseBody = objectMapper.writeValueAsString(new Cars(cars));

        when(carCatalogueService.getAllCars()).thenReturn(cars);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                                                .get("/api/cars/all")
                                                .accept(MediaType.APPLICATION_JSON))
                                                .andReturn()
                                                .getResponse();

        assertEquals(200, response.getStatus());
        assertEquals(expectedResponseBody, response.getContentAsString());
    }

}
