package com.SamHCoco.microservices.user.service;

import com.SamHCoco.microservices.user.service.model.Address;
import com.SamHCoco.microservices.user.service.model.Contact;
import com.SamHCoco.microservices.user.service.model.User;

/**
 * Class to simplify creating User objects.
 */
public class UserBuilder {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String postcode;
    private String location;

    public UserBuilder id(Long id){
        this.id = id;
        return this;
    }

    public UserBuilder userName(String userName){
        this.userName = userName;
        return this;
    }

    public UserBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public UserBuilder phone(String phone){
        this.phone = phone;
        return this;
    }

    public UserBuilder email(String email){
        this.email = email;
        return this;
    }

    public UserBuilder street(String street){
        this.street = street;
        return this;
    }

    public UserBuilder city(String city){
        this.city = city;
        return this;
    }

    public UserBuilder postcode(String postcode){
        this.postcode = postcode;
        return this;
    }

    public UserBuilder location(String location){
        this.location = location;
        return this;
    }

    public User build(){
        Contact contact = new Contact(email, phone);
        Address address = new Address(street, city, postcode, location);
        return new User(id, userName, firstName, lastName, address, contact);
    }
}
