package com.SamHCoco.microservices.carviewingservice.models.user;

public class Address {

    private String street;
    private String city;
    private String postcode;
    private String location;

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
