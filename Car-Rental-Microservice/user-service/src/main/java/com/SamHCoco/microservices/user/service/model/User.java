package com.SamHCoco.microservices.user.service.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "USERNAME cannot be null")
    @NotEmpty(message = "USERNAME cannot be empty")
    @Size(min = 1, max = 30, message = "USERNAME must be 1 to 30 characters long")
    private String userName;

    @NotNull(message = "FIRST NAME cannot be null")
    @NotEmpty(message = "FIRST NAME cannot be empty")
    @Size(min = 1, max = 30, message = "FIRST NAME must be 1 to 30 characters long")
    private String firstName;

    @NotNull(message = "LAST NAME cannot be null")
    @NotEmpty(message = "LAST NAME cannot be empty")
    @Size(min = 1, max = 30, message = "LAST NAME must be 1 to 30 characters long")
    private String lastName;

    @Embedded
    private Address address;

    @Embedded
    private Contact contact;

    // empty constructor for Hibernate to work with
    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String toString(){
        return "USER: " + "\n" +
                "id: " + id + "\n" +
                "name: " + firstName + "\n" +
                "surname: " + lastName + "\n" +
                address +
                contact;
    }

}
