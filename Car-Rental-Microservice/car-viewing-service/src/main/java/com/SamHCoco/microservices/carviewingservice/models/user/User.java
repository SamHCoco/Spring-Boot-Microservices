package com.SamHCoco.microservices.carviewingservice.models.user;

public class User {

    // todo - validate fields
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;

    private Address address;

    private Contact contact;

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
