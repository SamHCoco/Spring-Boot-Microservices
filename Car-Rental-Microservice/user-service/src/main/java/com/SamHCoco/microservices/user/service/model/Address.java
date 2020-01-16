package com.SamHCoco.microservices.user.service.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

    @NotNull(message = "STREET cannot be null")
    @NotEmpty(message = "STREET cannot be empty")
    @Size(min = 1, max = 30, message = "STREET must be between 1 and 30 characters")
    private String street;

    @NotNull(message = "CITY cannot be null")
    @NotEmpty(message = "CITY cannot be empty")
    @Size(min = 1, max = 30, message = "CITY must be between 1 and 30 characters")
    private String city;

    @NotNull(message = "POSTCODE cannot be null")
    @NotEmpty(message = "POSTCODE cannot be empty")
    @Size(min = 1, max = 30, message = "POSTCODE must be between 1 and 30 characters")
    private String postcode;

    @NotNull(message = "LOCATION cannot be null")
    @NotEmpty(message = "LOCATION cannot be empty")
    @Size(min = 1, max = 30, message = "STREET must be between 1 and 30 characters")
    private String location;

    // empty constructor for Hibernate to work with
    public Address(){

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString(){
        return "  \nADDRESS: \n" +
                "  street: " + street + "\n" +
                "  city: " + city + "\n" +
                "  Postcode: " + postcode + "\n" +
                "  location: " + location + "\n";
    }
}
